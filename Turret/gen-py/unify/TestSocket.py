import socket
from unify.osx.turret.api.TurretRequestService import Client
from thrift.protocol import TBinaryProtocol
from thrift.transport import TSocket, TTransport

def client_program():
    #host = socket.gethostname()  # as both code is running on same pc
    host = "10.135.25.61"
    #host = "10."
    #port = 6999  # socket server port number

    #client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # instantiate
    #client_socket.connect((host, port))  # connect to the server

    #message = input(" -> ")  # take input

    transport = TSocket.TSocket("192.168.0.22", 9007)  # Replace with your server's host and port
    transport = TTransport.TBufferedTransport(transport)

# Create a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    ip = TSocket.TSocket("192.168.0.190")
    #ip = TTransport.TBufferedTransport(ip)

    # Create a client
    #client = Client.requestNotifications(protocol,'10.135.25.61')

    obj = Client(protocol)
    #print("#################", obj._iprot,obj._seqid)
    response = Client.requestNotifications(obj,ip)
   # response = client.requestNotifications('10.135.25.61')
    #print("Response:::"+response)
    # while message.lower().strip() != 'bye':
    #     client_socket.send(message.encode())  # send message
    #     data = client_socket.recv(1024).decode()  # receive response

    #     print('Received from server: ' + data)  # show in terminal

    #     message = input(" -> ")  # again take input

    #client_socket.close()  # close the connection


if __name__ == '__main__':
    client_program()