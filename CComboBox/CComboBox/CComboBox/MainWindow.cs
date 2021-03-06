﻿using System;
using Gtk;
using SerpisAd.Ad;
using MySql.Data.MySqlClient;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();

        App.Instance.Connection = new MySqlConnection("server=localhost;database=dbprueba;user=root;password=sistemas");
        App.Instance.Connection.Open();

        ComboBoxHelper.Fill(comboBox, "SELECT id, nombre FROM categoria ORDER BY nombre", 0);
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
