import socket
import time

from unify.osx.turret.api.TurretRequestService import Client
from thrift.protocol import TBinaryProtocol
from thrift.transport import TSocket, TTransport

def client_program():
   

    transport = TSocket.TSocket("192.168.0.22", 9007)  # Replace with your server's host and port
    transport = TTransport.TBufferedTransport(transport)

# Create a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    transport.open()
    data_to_send = "Hello, Thrift!"
    protocol.write(data_to_send)
    transport.flush()

# To read data
    received_data = protocol.read()
   
if __name__ == '__main__':
    client_program()