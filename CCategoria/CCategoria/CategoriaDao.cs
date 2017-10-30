using System;
using SerpisAd.Ad;
using System.Data;
namespace CCategoria

{
    public class CategoriaDao
    {
        public static Categoria Load(object id){
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "SELECT * FROM categoria WHERE id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", id);
			IDataReader dataReader = dbCommand.ExecuteReader();
			dataReader.Read();
			String nombre = (string)dataReader["nombre"];
			dataReader.Close();

			Categoria categoria = new Categoria();

			categoria.Id = Convert.ToInt64(id);
			categoria.Nombre = nombre;

            return categoria;
        }

        public static void Save (Categoria categoria) {
            if (categoria.Id == 0){
                Insert(categoria);
            }
            else{
                Update(categoria);
            }
        }

        private static void Insert(Categoria categoria){
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "INSERT INTO categoria (nombre) VALUES (@nombre)";
			DbCommandHelper.AddParameter(dbCommand, "nombre", categoria.Nombre);
			dbCommand.ExecuteNonQuery();
        }

        private static void Update(Categoria categoria){
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "UPDATE categoria SET nombre = @nombre WHERE id = @id";
            DbCommandHelper.AddParameter(dbCommand, "id", categoria.Id);
			DbCommandHelper.AddParameter(dbCommand, "nombre", categoria.Nombre);
			dbCommand.ExecuteNonQuery();
        }

        public static void Delete (object id){
			IDbCommand dbCommnand = App.Instance.Connection.CreateCommand();
			dbCommnand.CommandText = "DELETE FROM categoria WHERE id = @id";
			DbCommandHelper.AddParameter(dbCommnand, "id", id);
			dbCommnand.ExecuteNonQuery();
        }
    }
}
