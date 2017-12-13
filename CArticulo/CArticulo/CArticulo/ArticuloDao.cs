using System;
using System.Data;

using SerpisAd.Ad;
namespace CArticulo
{
	public class ArticuloDao
	{
		public const string SelectAll = "select * from articulo order by id";

		public static Articulo Load(object id)
		{
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "select * from articulo where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", id);
			IDataReader dataReader = dbCommand.ExecuteReader();
			dataReader.Read();
			string nombre = (string)dataReader["nombre"];
			decimal precio = (decimal)dataReader["precio"];
            decimal categoria = (decimal)dataReader["categoria"];
			dataReader.Close();

			Articulo articulo = new Articulo();
			articulo.Id = Convert.ToInt64(id);
			articulo.Nombre = nombre;
			articulo.Precio = precio;
			articulo.Precio = Convert.ToDecimal(precio);
            articulo.Categoria = (long)categoria;
			return articulo;
		}

		public static void Save(Articulo articulo)
		{
			if (articulo.Id == 0)
				Insert(articulo);
			else
				Update(articulo);
		}

		private static void Insert(Articulo articulo)
		{
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "insert into articulo (nombre, precio, categoria) values (@nombre, @precio, @categoria)";
			DbCommandHelper.AddParameter(dbCommand, "nombre", articulo.Nombre);
			DbCommandHelper.AddParameter(dbCommand, "precio", articulo.Precio);
            DbCommandHelper.AddParameter(dbCommand, "categoria", articulo.Categoria);
			dbCommand.ExecuteNonQuery();
		}

		private static void Update(Articulo articulo)
		{
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "update articulo set nombre = @nombre, precio = @precio categoria = @categoria where id = @id ";
			DbCommandHelper.AddParameter(dbCommand, "nombre", articulo.Nombre);
			DbCommandHelper.AddParameter(dbCommand, "id", articulo.Id);
			DbCommandHelper.AddParameter(dbCommand, "precio", articulo.Precio);
            DbCommandHelper.AddParameter(dbCommand, "categoria", articulo.Categoria);
			dbCommand.ExecuteNonQuery();
		}

		public static void Delete(object id)
		{
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "delete from articulo where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", id);
			dbCommand.ExecuteNonQuery();
		}
	}
}