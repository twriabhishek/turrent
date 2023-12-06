import socket


def server_program():
    # get the hostname
    host = "192.168.0.190"
    #host = socket.gethostname()
    #host = "115.241.66.187"
    print(host)
    port = 5003  # initiate port no above 1024

    #server_socket = socket.socket()  # get instance
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # look closely. The bind() function takes tuple as argument
    server_socket.bind((host, port))  # bind host address and port together

    # configure how many client the server can listen simultaneously
    server_socket.listen(1)
    #requestNotifications("192.168.0.190")
    conn, address = server_socket.accept()  # accept new connection
    print("Connection from: " + str(address))
    #data = input(' -> ')
    #conn.send(data.encode('utf8'))
    #data = conn.recv(1024).decode()
    while True:
        # receive data stream. it won't accept data packet greater than 1024 bytes
        data = conn.recv(1024).decode()
        print("############################################## " )
        if not data:
            # if data is not received break
            break
        print("from connected user: " + str(data))
        data = input(' -> ')
        conn.send(data.encode())  # send data to the client

    conn.close()  # close the connection


if __name__ == '__main__':
    server_program()