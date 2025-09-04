package org.binaryminds.gestionproyectos;

import java.util.List;
import java.util.Scanner;
import org.binaryminds.gestionproyectos.dominio.service.IUsuarioService;
import org.binaryminds.gestionproyectos.persistence.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionProyectosApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioService usuarioService;

	private static final Logger logger = LoggerFactory.getLogger(GestionProyectosApplication.class);

	String sl = System.lineSeparator();

	public static void main(String[] args) {
		SpringApplication.run(GestionProyectosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gestionProyectosApp();
	}

	private void gestionProyectosApp() {
		logger.info(sl+sl+"+++++++++SISTEMA DE GESTIÓN DE PROYECTOS++++++++++");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenu(Scanner consola) {
		logger.info("""
				\n***Aplicación***
				1. Registrar usuario
				2. Iniciar sesion
				3. Salir.
				Elije una opción: \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		var salir = false;
		switch (opcion) {
			case 1 -> {
				logger.info("***REGITRAR USUARIO***"+sl);
				logger.info("Ingrese su nombre: ");
				var nombre = consola.nextLine();
				logger.info("Ingrese su email: ");
				var email = consola.nextLine();
				logger.info("Ingrese su contraseña: ");
				var contrasena = consola.nextLine();
				logger.info("Ingrese su rol ('usuario' o 'administrador'): ");
				var rol = consola.nextLine();

				var usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setEmail(email);
				usuario.setContrasena(contrasena);
				usuario.setRol(rol);

				usuarioService.guardarUsuario(usuario);
			}
			case 2 -> {
				logger.info(sl+"***INICIAR SESION***"+sl);
				logger.info(sl+"Ingrese su email: ");
				var email = consola.nextLine();
				logger.info(sl+"Ingrese su contraseña: ");
				var contrasena = consola.nextLine();

				List<Usuario> usuarios = usuarioService.listarUsuarios();

				for (Usuario usuario : usuarios){
					if (usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)){
						logger.info(sl+"Inicio exitoso"+sl);
					} else {
						logger.info(sl+"Usuario no encontrado"+sl);
					}
				}

			}
			case 3 -> {
				logger.info("Hasta pronto. vaquero!"+sl+sl);
				salir = true;
				System.exit(0);
			}
			default -> {
				logger.info(sl+"Opción inválida"+sl);
			}
		}
		return false;
	}
}
