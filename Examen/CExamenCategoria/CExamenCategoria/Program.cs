using System;
using System.Data;
using MySql.Data.MySqlClient;
using SerpisAd.Ad;

namespace Serpis.Ad
{
    //TODO completar
    class MainClass
    {
        private static IDbConnection dbConnection;
        public static void Main(string[] args)
        {

            dbConnection = new MySqlConnection("server=localhost;database=dbprueba;user=root;password=sistemas");
            dbConnection.Open();

			//IDbCommand dbCommand = dbConnection.CreateCommand();
			//dbCommand.CommandText = "select * from categoria";
			//IDataReader dataReader = dbCommand.ExecuteReader();
			//while (dataReader.Read())
			//	Console.WriteLine("id={0} nombre={1}", dataReader["id"], dataReader["nombre"]);
			//dataReader.Close();


            //----- RESPETAR ESTE CODIGO -----

            Categoria categoria = load(1L);
            categoria.Nombre = categoria.Nombre + "#c";
            update(categoria);

            //----------------------------------

            dbConnection.Close();
        }

        private static Categoria load(object id) {
            IDbCommand dbCommand = dbConnection.CreateCommand();
			dbCommand.CommandText = "select * from categoria where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", id);
			IDataReader dataReader = dbCommand.ExecuteReader();
			dataReader.Read();
			string nombre = (string)dataReader["nombre"];
			dataReader.Close();
			Categoria categoria = new Categoria();
			categoria.Id = Convert.ToInt64(id);
			categoria.Nombre = nombre;
			return categoria;
        }

        private static void update(Categoria categoria) {
			IDbCommand dbCommand = dbConnection.CreateCommand();
			dbCommand.CommandText = "update categoria set nombre=@nombre where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", categoria.Id);
			DbCommandHelper.AddParameter(dbCommand, "nombre", categoria.Nombre);
			dbCommand.ExecuteNonQuery();
        }
    }
}
