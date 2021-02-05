using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteTemperatura
{
    public partial class formClima : Form
    {
        ServicioClima.WsClimaClient clima;
        public formClima()
        {
            InitializeComponent();
            selectFormato.Items.Insert(0, "Temperatura");
            selectFormato.Items.Insert(1, "Probabilidad LLuvia");
            clima = new ServicioClima.WsClimaClient();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }

        private void selectFormato_SelectedIndexChanged(object sender, EventArgs e)
        {
            String fecha = txtFecha.Text;
            String valor = selectFormato.Text;
            String res = "";
            if (valor == "Temperatura") {
               res = clima.getClimaTemperatura(fecha.ToString());
                txtRes.Text = res.ToString();
            }
            else
            {
                res = clima.getClimaPorcentaje(fecha.ToString());
                txtRes.Text = res.ToString();
            }
        }
    }
}
