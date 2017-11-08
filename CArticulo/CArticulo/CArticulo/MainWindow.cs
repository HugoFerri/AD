using System;
using Gtk;
using SerpisAd.Ad;
using System.Data;
using MySql.Data.MySqlClient;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
		Build();
		Title = "Articulo";
		App.Instance.Connection = new MySqlConnection("server=localhost;database=dbprueba;user=root;password=sistemas");
		App.Instance.Connection.Open();
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
