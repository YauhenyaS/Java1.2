package ru.geekbrains.Less6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler { // обработчик
    public static int clientCounter = 0;
    private int clientNumber;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread handlerThread;
    private Server server;// ссылка на server для возможности отправки дрю клиентам

    public Handler(Socket socket, Server server){
        try{
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Handler created");
            this.clientNumber = ++clientCounter;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle(){// для обработки сообщений
        handlerThread = new Thread(() -> {
           while (!Thread.currentThread().isInterrupted() && socket.isConnected()){
               try{
                   String message = in.readUTF();// ждет сообщение
                   message = "client #" + this.clientNumber + ": " + message;
                   server.broadcast(message);//сервер просит всех handler отправить своему клиенту это сообщение
                   System.out.printf("Client #%d: %s\n", this.clientNumber, message);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        });
        handlerThread.start();;
    }

    public void send( String msg){
        try{
            out.writeUTF(msg);// у потока вывода просит отправить msg в сеть
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Thread getHandlerThread(){
        return handlerThread;
    }
}
