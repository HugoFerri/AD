using System;
using Gtk;
using MySql.Data.MySqlClient;
using System.Data;
using CCategoria;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        String conex = "server=localhost; database=dbprueba; user=root; password=sistemas";
        App.Instance.Connection = new MySqlConnection(conex);
        App.Instance.Connection.Open();

        Build();

        //declaracion de las coliumnas
        treeView.AppendColumn("id", new CellRendererText(), "text", 0);
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);

        //declaracion de la lista y los tipos que va a contener
        ListStore listStore = new ListStore(typeof(ulong), typeof(String));

		//Le indico la plantilla  seguir
		treeView.Model = listStore;

        //Consulta SQL
		IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
		dbCommand.CommandText = "select * from categoria";

        //Recorro el resultado de la consulta
		IDataReader dataReader = dbCommand.ExecuteReader();
        while (dataReader.Read())
            listStore.AppendValues(dataReader["id"], dataReader["nombre"]);
        dataReader.Close();

        newAction.Activated += delegate {
            new CategoriaWindow();
        };

    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        App.Instance.Connection.Close();

        Application.Quit();
        a.RetVal = true;
    }
}
