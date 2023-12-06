import socket
from unify.osx.turret.api.TurretRequestService import Client

def client_program():
    #host = socket.gethostname()  # as both code is running on same pc
    host = "192.168.0.22"
   
    port = 9007  # socket server port number

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # instantiate
    client_socket.connect((host, port))  # connect to the server

    message = input(" -> ")  # take input
    #response = Client.requestNotifications("","192.168.0.190")
    #print("Reponse:::::  "+response)
    # while message.lower().strip() != 'bye':
    #     client_socket.send(message.encode())  # send message
    #     data = client_socket.recv(1024).decode()  # receive response

    #     print('Received from server: ' + data)  # show in terminal

    #     message = input(" -> ")  # again take input

    client_socket.close()  # close the connection


if __name__ == '__main__':
    client_program()