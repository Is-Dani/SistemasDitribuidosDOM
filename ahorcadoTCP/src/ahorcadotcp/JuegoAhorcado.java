/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadotcp;

import java.util.ArrayList;

/**
 *
 * @author Dani
 */
public class JuegoAhorcado {

    ArrayList<String> listapalabras;

    String palabraAdivinar;
    int numeroFallos;
    String guiones;

    public JuegoAhorcado() {
        listapalabras = new ArrayList<String>();
        listapalabras.add("distribuidos");
        listapalabras.add("sistemas");
        listapalabras.add("concistencia");
        listapalabras.add("compartido");
        listapalabras.add("transparencia");
        listapalabras.add("computadora");
        listapalabras.add("estado");
        IniciarJuego();

    }

    public void IniciarJuego() {
        this.numeroFallos = 0;
        this.guiones = "";
        int numero = (int) Math.random() * listapalabras.size();
        palabraAdivinar = listapalabras.get(numero);

        for (int i = 0; i < palabraAdivinar.length(); i++) {
            guiones += "-";
        }
    }

    public boolean ExisteLetra(char letra) {
        if (palabraAdivinar.indexOf(letra) == -1) {
            return false;
        } else {
            return true;
        }

    }

    private void ReemplazarGuiones(char letra) {
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letra) {
                guiones = guiones.substring(0, i) + letra + guiones.substring(i + 1);
            }
        }
    }

    public String Jugar(char letra) {
        if (ExisteLetra(letra)) {
            ReemplazarGuiones(letra);
            if (guiones.equals(palabraAdivinar)) {
                return "Ganaste,"+this.guiones;
            } else {
                return "Seguir,"+this.guiones;
            }
        } else {
            numeroFallos++;
            if (numeroFallos == 9) {
                return "Perdiste,"+this.guiones;
            } else {
                return "Seguir,"+this.guiones;
            }
        }
    }

    public String getGuiones() {
        return guiones;
    }

    public int getNumeroFallos() {
        return numeroFallos;
    }

}
