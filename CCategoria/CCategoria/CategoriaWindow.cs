using System;
using System.Data;
using SerpisAd.Ad;

namespace CCategoria
{
    public partial class CategoriaWindow : Gtk.Window
    {
        public CategoriaWindow(object id) : this (){
            this.Build();

            Categoria categoria = CategoriaDao.Load(id);
            entryNombre.Text = categoria.Nombre;

            saveAction.Activated += delegate {
                CategoriaDao.Save();
                Destroy();
            };
        }

        public CategoriaWindow() : base(Gtk.WindowType.Toplevel){
			this.Build();

			saveAction.Activated += delegate {
                CategoriaDao.Save();
				Destroy();
            };
        }
    }
}
