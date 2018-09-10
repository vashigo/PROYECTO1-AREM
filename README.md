# PROYECTO AREM WEBSERVER

servidor Web (tipo Apache) en Java. Servidor capaz de entregar páginas html e imágenes tipo PNG atendiendo múltiples solicitudes no concurrentes.

## Link del Articulo del proyecto

[Link Articulo](https://drive.google.com/file/d/1xJQrIGzxCvEgKT1WywZ4KVCSRpClu2Ws/view?usp=sharing)


## Link Funcional Aplicacion Web en Heroku

[con solo HTML](https://proyecto1-arem.herokuapp.com/index.html)

[con solo .png](https://proyecto1-arem.herokuapp.com/imagen.png)


## EMPEZAR

Copie el proyecto via git clone en cualquier diretorio para empezar a trabajar:
```
git clone https://github.com/vashigo/PROYECTO1-AREM.git
```

### Prerequisitos

Tener instalado Java jdk versiones 7+, Maven comandos y git

### Instalando

1. Ejecutar en terminal:

```
$$ mvn package
```
2.(opcional):
si requiere la documetacion del codigo

```
mvn javadoc:javadoc
```
### Ejecutando

2. (Demostracion):
  compile el proyecto en terminal desde la carpeta raiz ejecutando la siguiente linea:
  
```
java -cp target/HttpServer-1.0.0-jar-with-dependencies.jar co.edu.escuelaing.arem.HttpServer.HttpServer
  
```

3. (server):
una vez compilado el programa se ejecuta en el puerto 4567,para probarlo vaya a esta direccion desde su navegador:

```
http://localhost:4567/index.html
  
```
```
http://localhost:4567/imagen.png
  
```


## Autor

* **ANDRES DAVID VASQUEZ IBAÑEZ** - *Initial work* - [VASHIGO](https://github.com/vashigo)


## Licencia

This project is licensed under the GNU General Public License - see the [LICENSE](LICENSE) file for details


