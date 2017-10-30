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
            if (categoria.Id == 0)
            {
				string nombre = entryNombre.Text;
				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
				DbCommandHelper.AddParameter(dbCommand, "nombre", categoria.nombre);
				dbCommand.ExecuteNonQuery();
            }
            else{
				string nombre = entryNombre.Text;
				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = "UPDATE categoria SET nombre = @nombre WHERE id = @id";
				DbCommandHelper.AddParameter(dbCommand, "nombre", categoria.nombre);
				DbCommandHelper.AddParameter(dbCommand, "id", categoria.id);
				dbCommand.ExecuteNonQuery();
            }
        }

        public static void Delete (object id){
            
        }
    }
}
