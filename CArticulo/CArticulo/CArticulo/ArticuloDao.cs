﻿using System;
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
			dataReader.Read();//TODO tratamiento de excepciones
			string nombre = (string)dataReader["nombre"];
			decimal precio = (decimal)dataReader["precio"];
			dataReader.Close();
			Articulo articulo = new Articulo();
			articulo.Id = Convert.ToInt64(id);
			articulo.Nombre = nombre;
			articulo.Precio = precio;
			articulo.Precio = Convert.ToDecimal(precio);
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
			dbCommand.CommandText = "insert into articulo (nombre, precio) values (@nombre, @precio)";
			DbCommandHelper.AddParameter(dbCommand, "nombre", articulo.Nombre);
			DbCommandHelper.AddParameter(dbCommand, "precio", articulo.Precio);
			dbCommand.ExecuteNonQuery();
		}

		private static void Update(Articulo articulo)
		{
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "update articulo set nombre = @nombre, precio = @precio where id = @id ";
			DbCommandHelper.AddParameter(dbCommand, "nombre", articulo.Nombre);
			DbCommandHelper.AddParameter(dbCommand, "id", articulo.Id);
			DbCommandHelper.AddParameter(dbCommand, "precio", articulo.Precio);
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