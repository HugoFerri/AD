using System;
namespace CCategoria
{
    public class Categoria
    {
        public Categoria(){
        }

        private long id;
        private String nombre = "";

        public long Id {
            get { return id; }
            set { id = value; }
        }

		public String Nombre {
			get { return nombre; }
			set { nombre = value; }
		}
    }
}
