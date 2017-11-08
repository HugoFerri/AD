using System;
namespace CArticulo
{
    public class Articulo
    {
		private long id;
		private String nombre = "";
        private decimal precio;
        private long categoria;

		public long Id{
			get { return id; }
			set { id = value; }
		}

		public String Nombre{
			get { return nombre; }
			set { nombre = value; }
		}

		public long Categoria{
			get { return categoria; }
			set { categoria = value; }
		}

        public decimal Precio{
			get { return precio; }
			set { precio = value; }
		}
    }
}
