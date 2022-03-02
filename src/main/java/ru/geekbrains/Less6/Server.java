package ru.geekbrains.Less6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 8189;
    private List<Handler> handlers;

    public Server(){this.handlers = new ArrayList<>();
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {//ServerSocket - создание сервера
            System.out.println("Server start");

            while(true){
                System.out.println("Waiting for connection ...");
                Socket socket = serverSocket.accept();//ждет подключения
                System.out.println("Client connected");
                Handler handler = new Handler(socket, this);//при подключении создает handler
                handlers.add(handler);//добавляет handler в список
                handler.handle();//вызывает обработку сообщений
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message){//отправка общего для всех сообщения
        for(Handler handler : handlers){
            handler.send(message);
        }
    }
}
