package SITESACO;
//clase hija

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Pacientes extends Persona {
    //Atributos ˙nicos de pacientes

    private String fechaing;
    private String fechasal;
    private String tratamiento;
    private Medicos medicotrata;

    //Constructor
    public Pacientes(String fechaing, String tratamiento, String nombre, String doc, String nacimiento) {
        super(nombre, doc, nacimiento);
        this.fechaing = fechaing;
        this.tratamiento = tratamiento;
        this.medicotrata = medicotrata;
    }

    public Pacientes() {
        super("", "", "");

    }

    //MÈtodos getters y setters
    public Medicos getMedicotrata() {
        return medicotrata;
    }

    public void setMedicotrata(Medicos medicotrata) {
        this.medicotrata = medicotrata;
    }

    public String getFechaing() {
        return fechaing;
    }

    public void setFechaing(String fechaing) {
        this.fechaing = fechaing;
    }

    public String getFechasal() {
        return fechasal;
    }

    public void setFechasal(String fechasal) {
        this.fechasal = fechasal;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    //MÈtodos sobreescritos
    @Override
    public void agregarPersona() {
        //Input del usuario para los atributos del paciente
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre completo del paciente ");
        this.doc = JOptionPane.showInputDialog("Ingrese el documento de identidad ");
        this.nacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento ");
        this.fechaing = JOptionPane.showInputDialog("Ingrese la fecha de ingreso");
        int opcesp = 0;
        do {
            //Men˙ para modificar atributos de un empleado
            String l = JOptionPane.showInputDialog("Escoja el campo para el tratamiento del paciente: \n"
                    + "1.AngiologÌa\n"
                    + "2.DermatologÌa\n"
                    + "3.GinecologÌa\n"
                    + "4.OftamologÌa\n"
                    + "5.OtorrinolaringologÌa\n"
                    + "6.UrologÌa\n"
                    + "7.TraumatologÌa\n");
            opcesp = Integer.parseInt(l);
            switch (opcesp) {
                //Cases para asginar tratamiento
                case 1:
                    tratamiento = "Angiologia";
                    break;
                case 2:
                    tratamiento = "Dermatologia";
                    break;
                case 3:
                    tratamiento = "Ginecologia";
                    break;
                case 4:
                    tratamiento = "Oftamologia";
                    break;
                case 5:
                    tratamiento = "Otorrinolaringologia";
                    break;
                case 6:
                    tratamiento = "Urologia";
                    break;
                case 7:
                    tratamiento = "Traumatologia";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Esa opciÛn no existe");
                    break;

            }
        } while (opcesp == 0);

    }

    @Override
    public void verLista(ArrayList<Persona> pacientes) {
        //Un for each para mostrar todos los pacientes en el ArrayList pacientes
        System.out.println("LISTA DE PACIENTES");
        for (Persona per : pacientes) {
            System.out.println("Nombre: \n" + per.getNombre() + "\nDocumento de identidad: \n" + per.getDoc());
            System.out.println("====================================================================");
        }

    }

    @Override
    public void verDetalles() {
        //MÈtodo para imprimir todos los atributos de un paciente
        System.out.println("Nombre: \n" + this.getNombre() + "\nDocumento de identidad: \n" + this.getDoc() + "\nFecha de nacimiento: \n" + this.getNacimiento()
                + "\nFecha de ingreso: \n" + this.getFechaing() + "\nTratamiento: \n" + this.getTratamiento());
        //Si tiene fecha de salida la imprime
        if (this.getFechasal() != null) {
            System.out.println("\nFecha de salida: \n" + this.getFechasal());
        }
        if (this.getMedicotrata() != null) {
            System.out.println("\nAtendido por: \n" + this.getMedicotrata().getNombre());
        } 
        else {
            System.out.println("====================================================================");
        }
    }

    @Override
    public void Eliminar(ArrayList<Persona> pacientes) {
        //MÈtodo para eliminar un paciente
        //Busca el paciente que se quiere eliminar
        Persona enconpaci = buscar(pacientes);
        if (enconpaci != null) {
            //Remueve el paciente del ArrayList
            pacientes.remove(enconpaci);
            JOptionPane.showMessageDialog(null, "Paciente eliminado con Èxito");
        } 
        else {
            JOptionPane.showMessageDialog(null, "No existe ese paciente");

        }

    }

    public void darAlta(ArrayList<Persona> pacientes) {
        //MÈtodo para dar de alta a un paciente
        //Busca el paciente que se quiere dar de alta
        Persona enconpaci = buscar(pacientes);
        if (enconpaci == null) {
            JOptionPane.showMessageDialog(null, "No existe ese paciente");
        } 
        else {
            Pacientes pacien1 = (Pacientes) enconpaci;
            pacien1.setFechasal(JOptionPane.showInputDialog("Ingrese la fecha de salida"));
            JOptionPane.showMessageDialog(null, "Paciente dado de alta");

        }

    }

    @Override
    public Persona buscar(ArrayList<Persona> persona) {
        //MÈtodo para buscar a un paciente mediente su documento de identidad
        String cedula = JOptionPane.showInputDialog("Ingrese el numero de documento de identidad del paciente a buscar");

        for (Persona per : persona) {
            if (per.getDoc().equals(cedula)) {
                return per;
            }
        }
        return null;
    }

    //MÈtodos propios
    public void asignarMedicoPorEspecialidad(ArrayList<Persona> medicos) {
        //ArrayList donde se guardaran los mÈdico que tenga la especialidad que requiere el paciente
        ArrayList<Persona> medicosesp = new ArrayList<Persona>();
        boolean existeesp=false;
        for (Persona med : medicos) {
            Medicos med1 = (Medicos) med;
            for (Especialidad esp : med1.getEspecialidad()) {
                if (esp.getNombre().equals(this.getTratamiento())) {
                    medicosesp.add(med1);
                }
            }

        }
        //Muestra todos los mÈdicos disponibles para ese tratamiente
        System.out.println("MÈdico(s) para " + this.getTratamiento());
        for (Persona medaten : medicosesp) {
            System.out.println("Nombre: \n" + medaten.getNombre() + "\nDocumento de indentidad: \n" + medaten.getDoc() + "\n");
            System.out.println("====================================================================");
        }
        //Busca el medico que el usuario desee para el paciente
        Medicos med2 = new Medicos();
        med2 = (Medicos) med2.buscar(medicos);
        if (med2 != null) {
            for (Especialidad esp2 : med2.getEspecialidad()) {
                if (esp2.getNombre().equals(this.getTratamiento())) {
                    this.setMedicotrata(med2);
                    JOptionPane.showMessageDialog(null, "MÈdico agregado con Èxito");
                    existeesp = true;
                    break;
                }
            }

        } 
        else  if(existeesp == false){
            JOptionPane.showMessageDialog(null, "No existe mÈdico para ese tratamiento");

        }

    }
    public static ArrayList<Persona> convertirTXTaObjetos(String txtPacientes,  ArrayList<Persona> medicos) {
		ArrayList<Persona> lista = new ArrayList<Persona>();
		// Iterar la linea , separada por #
		String[] pacientes = txtPacientes.split("#");
		for (int i = 1; i < pacientes.length; i++) {
			String pac = pacientes[i];
			// iterar atributos de empleados
			String[] campos = pac.split(",");
			// Crear persona de tipo paciente
			if(campos[0]!=null)  { 
				// String fechaing, String tratamiento, String nombre, String doc, String nacimiento
				Pacientes nuevaPersona = new Pacientes(campos[0], campos[1], campos[2], campos[3], campos[4]);
				// buscar si tiene doctor tratante
				if(campos.length > 5 ) {
					String medDocumento = campos[5];
					if(medDocumento!=null ) {
						for (Persona med : medicos) {
							// si el doc del medico coincide, lo asinamos al paciente
				            if (med.getDoc().equals(medDocumento)) {
				                nuevaPersona.setMedicotrata((Medicos) med);
				            }
				        }
					}
				}
				lista.add(nuevaPersona);
			}
		}
		
		return lista;
	}
}


