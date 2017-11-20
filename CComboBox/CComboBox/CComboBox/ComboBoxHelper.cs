using Gtk;
using System;
using System.Data;

namespace SerpisAd.Ad
{
    public class ComboBoxHelper
    {
        public const String NullLabel = "< Sin asignar >";
        public static void Fill(ComboBox comboBox, String selectSql, object id){
            CellRendererText cellRendererText = new CellRendererText();

            comboBox.PackStart(cellRendererText, false);
            comboBox.AddAttribute(cellRendererText, "text", 1);

			IDbCommand dbCommnand = App.Instance.Connection.CreateCommand();
			dbCommnand.CommandText = selectSql;
			IDataReader dataReader = dbCommnand.ExecuteReader();

            ListStore listStore = new ListStore(typeof(String), typeof(String));
            comboBox.Model = listStore;
            TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);

            while(dataReader.Read()){
                TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(), dataReader[1].ToString());
                if (id.Equals(dataReader[0]))
                    initialTreeIter = treeIter;
            }
            comboBox.SetActiveIter(initialTreeIter);
        }
    }
}
