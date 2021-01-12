
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class SimpleChat extends ReceiverAdapter {

    JChannel channel;
    //String user_name=System.getProperty("user.name", "n/a");
    private String mesa;

    public SimpleChat(String mesa) {
        this.mesa = mesa;
    }

    public SimpleChat() {

    }

    final List<String> state = new LinkedList<>();

    public void viewAccepted(View new_view) {
        System.out.println("** vista: " + new_view);
    }

    public void receive(Message msg) {
        String line = msg.getSrc() + ": " + msg.getObject();
        System.out.println(line);
        synchronized (state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String vJuan = "";
        String vMaria = "";
        String vDavid = "";
        while (true) {

            try {
                String line = "";
                System.out.print("> ");
                System.out.flush();
                System.out.println("Numero de MESA");
                String nmesa = in.readLine().toLowerCase();

                System.out.println("mesa:" + nmesa + " Juan, Maria, David");
                vJuan = in.readLine().toLowerCase();
                vMaria = in.readLine().toLowerCase();
                vDavid = in.readLine().toLowerCase();
                int a = 0;
                int b = 0;
                int c = 0;
                String[] cadena = {};
                if (!this.state.isEmpty()) {
                    for (String s : this.state) {
                        cadena = s.split(":");
                    }
                    a = Integer.parseInt(vJuan) + Integer.parseInt(cadena[2]);
                    b = Integer.parseInt(vMaria) + Integer.parseInt(cadena[4]);
                    c = Integer.parseInt(vDavid) + Integer.parseInt(cadena[6]);
                    line = "Voto Juan:" + a + ":" + " Voto Maria:" + b + ":" + " Voto David:" + c + ":";

                }else{
                    line = "Voto Juan:" + vJuan + ":" + " Voto Maria:" + vMaria + ":" + " Voto David:" + vDavid+ ":";
                }

                //String line = in.readLine().toLowerCase();
                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break;
                }
                line = "[" + mesa + "] " + line;

                Message msg = new Message(null, line);
                channel.send(msg);
            } catch (Exception e) {
            }
        }
    }

    //public String sumatoriaVotos(){
    // int vJ = 0;
    //int vM = 0;
    //int vD = 0;
    //for(String s : this.state){
    //      String[] cadena = s.split(": ");
    //        vJ += Integer.parseInt(cadena[0]);
    //          vM += Integer.parseInt(cadena[0]);
//            vD += Integer.parseInt(cadena[0]);
    //}
    //return "nada";
    //}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Numero de Mesa");
        //String mesa;
        //mesa = sc.next();
        //new SimpleChat(mesa).start();

        new SimpleChat().start();
    }
}
