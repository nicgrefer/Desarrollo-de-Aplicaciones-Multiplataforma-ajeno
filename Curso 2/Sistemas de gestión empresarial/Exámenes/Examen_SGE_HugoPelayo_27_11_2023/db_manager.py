##########################################
# Examen de SGE                          #
#                                        #
# Hugo Pelayo                            #
# 27 nov 2023                            #
##########################################

import mysql.connector

"""
    Monitoriza una conexión a una base de datos MySQL local (se conecta al localhost),
    por ello no recibe la dirección del servidor.
"""
class DBManager:
    
    def __init__(self, user, password):
        self.user = user
        self.password = password
        self.connection = None
        self.cursor = None
        
        try:
            self.connection = mysql.connector.connect(
                host="localhost",
                user=self.user,
                password=self.password,
            )
            
            # creamos cursor para las queries si la conexión se hizo con éxito
            self.cursor = self.connection.cursor()
            
            print("conexión establecida con éxito")
        except:
            print("Erro al conectar a la base de datos")
          
          
    def create_db(self, db_name):
        return self.execute(f"CREATE DATABASE IF NOT EXISTS {db_name}") and self.execute(f"USE {db_name}")
        
         
    def execute(self, query):
        try:
            self.cursor.execute(query)
            
            # salvamos los cambios en la bd
            # ya que el commit automático está desactivado por defecto
            self.connection.commit()
            return True
        except:
            print("Error al ejecutar la query")
            return False
    
    