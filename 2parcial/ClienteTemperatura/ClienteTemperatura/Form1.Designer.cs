
namespace ClienteTemperatura
{
    partial class formClima
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.selectFormato = new System.Windows.Forms.ComboBox();
            this.txtFecha = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtRes = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // selectFormato
            // 
            this.selectFormato.FormattingEnabled = true;
            this.selectFormato.Location = new System.Drawing.Point(287, 185);
            this.selectFormato.Name = "selectFormato";
            this.selectFormato.Size = new System.Drawing.Size(121, 24);
            this.selectFormato.TabIndex = 0;
            this.selectFormato.Text = "seleccionar";
            this.selectFormato.SelectedIndexChanged += new System.EventHandler(this.selectFormato_SelectedIndexChanged);
            // 
            // txtFecha
            // 
            this.txtFecha.Location = new System.Drawing.Point(287, 82);
            this.txtFecha.Name = "txtFecha";
            this.txtFecha.Size = new System.Drawing.Size(108, 22);
            this.txtFecha.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(314, 53);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(43, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "fecha";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(314, 155);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Formato";
            // 
            // txtRes
            // 
            this.txtRes.AutoSize = true;
            this.txtRes.Location = new System.Drawing.Point(314, 281);
            this.txtRes.Name = "txtRes";
            this.txtRes.Size = new System.Drawing.Size(76, 17);
            this.txtRes.TabIndex = 4;
            this.txtRes.Text = "Respuesta";
            // 
            // formClima
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.txtRes);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtFecha);
            this.Controls.Add(this.selectFormato);
            this.Name = "formClima";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox selectFormato;
        private System.Windows.Forms.TextBox txtFecha;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label txtRes;
    }
}

