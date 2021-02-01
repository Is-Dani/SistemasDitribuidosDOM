using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace OperacionCliente
{
    public partial class Form1 : Form
    {
        ServicioOp.OperacionesClient cliente;
        public Form1()
        {
            InitializeComponent();
            cliente = new ServicioOp.OperacionesClient();
        }

        private void btnSuma_Click(object sender, EventArgs e)
        {
            int n1 = int.Parse(num1.Text);
            int n2 = int.Parse(num2.Text);

            int res = cliente.suma(n1,n2);
            result.Text = res.ToString();

        }

        private void btnResta_Click(object sender, EventArgs e)
        {
            int n1 = int.Parse(num1.Text);
            int n2 = int.Parse(num2.Text);

            int res = cliente.restar(n1, n2);
            result.Text = res.ToString();
        }

        private void btnMulti_Click(object sender, EventArgs e)
        {
            int n1 = int.Parse(num1.Text);
            int n2 = int.Parse(num2.Text);

            int res = cliente.multiplicacion(n1, n2);
            result.Text = res.ToString();
        }

        private void btnDivi_Click(object sender, EventArgs e)
        {
            int n1 = int.Parse(num1.Text);
            int n2 = int.Parse(num2.Text);

            int res = cliente.division(n1, n2);
            result.Text = res.ToString();
        }
    }
}
