package SITESACO;
//subclase de empleamdos

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Medicos extends Empleados {


//Atributos
    private String idmed;
    private ArrayList<Especialidad> especialidad;
    private String residente;

//Constructores
    public Medicos(String idmed, ArrayList<Especialidad> especialidad, String residente, String cargo, String tipocargo, int salario, String nombre, String doc, String nacimiento) {
        super(cargo, tipocargo, salario, nombre, doc, nacimiento);
        this.idmed = idmed;
        this.especialidad = especialidad;
        this.residente = residente;
    }

    public Medicos() {
        super();

    }

    public Medicos(Empleados empleado) {
        super(empleado.getCargo(), empleado.getTipocargo(), empleado.getSalario(), empleado.getNombre(), empleado.getDoc(), empleado.getNacimiento());
        
        this.especialidad = new ArrayList<Especialidad>();
    }

    //MÈtodos setters y getters
    public String getIdmed() {
        return idmed;
    }

    public void setIdmed(String idmed) {
        this.idmed = idmed;
    }

    public ArrayList<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(ArrayList<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }

//MÈtodos sobreescritos
    @Override
    //MÈtodo para definir los atributos de el mÈdico
    public void agregarPersona() {
        this.agregarEspecial();
        this.setIdmed(JOptionPane.showInputDialog("Ingrese el n˙mero de tarjeta profesional: "));
        this.setResidente(JOptionPane.showInputDialog("Ingrese si es residente o no: "));
    }

    @Override
    //MÈtodo para ver lista de medicos
    public void verLista(ArrayList<Persona> medicos) {
        //For each para recorre el arreglo de mÈdico e imprimir sus atributos
        System.out.println("LISTA DE M…DICOS");
        for (Persona med : medicos) {
            Medicos med2 = (Medicos) med;
            System.out.println("Nombre: \n" + med2.getNombre() + "\nDocumento de identidad: \n" + med2.getDoc()
                    + "\nTarjeta profesioanl: \n" + med2.getIdmed() + "\n====================================================================");
        }

    }

    @Override
    //MÈtodo para ver detalles de un mÈdico
    public void verDetalles() {
        /* System.out.println("Nombre:\n" + this.getNombre() + "\nTarjeta profesional:\n" + this.getIdmed());
        for (Especialidad esp : this.getEspecialidad()) {
            System.out.println("Especialidad: \n" + esp.getNombre());
        }*/

    }

    @Override
    //MÈtodo para elminar un mÈdico
    public void Eliminar(ArrayList<Persona> medicos) {
        /*Persona enconpaci = buscar(medicos);
        if (enconpaci != null) {
            medicos.remove(enconpaci);
            System.out.println("MÈdico eliminado con Èxito");
        } else {
            System.out.println("No existe ese mÈdico");

        }
         */
    }

    @Override
    //MÈtodo para buscar un mÈdico
    public Persona buscar(ArrayList<Persona> persona) {
        String cedula = JOptionPane.showInputDialog("Ingrese n˙mero de documento de identidad de mÈdico a buscar");
        for (Persona per : persona) {
            if (per.getDoc().equals(cedula)) {
                return per;
            }
        }
        return null;
    }
    public Medicos buscarMedico(ArrayList<Medicos> persona) {
        String cedula = JOptionPane.showInputDialog("Ingrese n˙mero de documento de identidad de mÈdico a buscar");
        for (Medicos per : persona) {
            if (per.getDoc().equals(cedula)) {
                return per;
            }
        }
        return null;
    }
    

    //MÈtodo para agregar una especialidad
    public void agregarEspecial() {
        //ArrayList para agregar las especialidades del mÈdico
        ArrayList<Especialidad> lista = new ArrayList<Especialidad>();
        int opcesp;
        String especial;
        do {
            //Men˙ para agregar la especialidad de un mÈdico
            String l = JOptionPane.showInputDialog("AÒada la nueva especialidad del mÈdico: \n"
                    + "1.AngiologÌa\n"
                    + "2.DermatologÌa\n"
                    + "3.GinecologÌa\n"
                    + "4.OftamologÌa\n"
                    + "5.OtorrinolaringologÌa\n"
                    + "6.UrologÌa\n"
                    + "7.TraumatologÌa\n"
                    + "0.No quiero agregar m·s especialidades");
            opcesp = Integer.parseInt(l);
            switch (opcesp) {
                //Cases para crea un objeto con el nombre de la especialidad y agregarlo al ArrayList lista
                case 1:
                    especial = "Angiologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 2:
                    especial = "Dermatologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 3:
                    especial = "Ginecologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 4:
                    especial = "Oftamologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 5:
                    especial = "Otorrinolaringologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 6:
                    especial = "Urologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 7:
                    especial = "Traumatologia";
                    lista.add(new Especialidad(especial));
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Esa opciÛn no existe");
                    break;

            }
        } while (opcesp != 0);
        this.getEspecialidad().addAll(lista);
    }

    public void eliminarMed(ArrayList<Persona> medicos, ArrayList<Medicos> medicosl, ArrayList<Persona> pacientes) {
        boolean tienemedico = false;
        //Busca el mÈdico que se quiere eliminar
        Persona enconmedico = buscar(medicos);
        //Revisa si existe el mÈdico
        if (enconmedico != null) {
            //Recorre todo el arreglo de pacientes
            for (Persona pacientecomun : pacientes) {
                Pacientes pacientecom1 = (Pacientes) pacientecomun;
                //Compara nombre de medio asignado del paciente con el nombre de mÈdico a elimnar
                if (pacientecom1.getMedicotrata() != null) {
                    if (pacientecom1.getMedicotrata().getNombre().equalsIgnoreCase(enconmedico.getNombre())) {
                        JOptionPane.showMessageDialog(null, "Este mÈdico no se puede eliminar porque est· atendiendo pacientes");
                        tienemedico = true;
                        break;
                    }

                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ese mÈdico no existe");
        }
        if (tienemedico == false) {
            medicos.remove(enconmedico);
            medicosl.remove(enconmedico);
            JOptionPane.showMessageDialog(null, "MÈdico eliminado con Èxito");
        }

    }

    public void verDetallesMedico(ArrayList<Persona> pacientes) {
        //Muestra todos los atributos del mÈdico
        System.out.println("Nombre:\n" + this.getNombre() + "\nDocumento de identidad :\n" + this.getDoc()
                + "\nTarjeta profesional:\n" + this.getIdmed());
        for (Especialidad esp : this.getEspecialidad()) {
            System.out.println("Especialidad: \n" + esp.getNombre());
        }
        //Busca en el arreglo pacientes 
        for (Persona pacientecomun : pacientes) {
            Pacientes pacientecom1 = (Pacientes) pacientecomun;
            //Si encuentra un paciente con el mÈdico asignado que se esta buscanco muestra ese paciente
            if (pacientecom1.getMedicotrata()!=null) {
            	if (pacientecom1.getMedicotrata().getDoc().equalsIgnoreCase(this.getDoc())) {
            		System.out.println("Pacientes del mÈdico: \n" + pacientecom1.getNombre() + ", Documento paciente: " + pacientecom1.getDoc());
            	}
            } 
        }
        System.out.println("====================================================================");

    }

    public static  ArrayList<Medicos> convertirTXTaObjetosMedicos(String txtEmpleados) {
        ArrayList<Medicos> lista = new ArrayList<Medicos>();
        // Iterar la linea , separada por #
        String[] empleados = txtEmpleados.split("#");
        for (int i = 1; i < empleados.length; i++) {
            String emp = empleados[i];
            // iterar atributos de empleados
            String[] campos = emp.split(",");
            // Crear persona
            if (campos[1] != null && campos[1].equals("medico") == true) { // carga en la lista a todos los medicos
                ArrayList<Especialidad> nuevaEspecialidad = new ArrayList<Especialidad>();

                if (campos.length > 8) {
                    String especialidades = campos[8]; // en el campo 8 estan las espcialidades que se separan por el caracter |

                    String[] especialidadLista = especialidades.split("/");
                    for (int j = 1; j < especialidadLista.length; j++) {
                        String esp = especialidadLista[j];
                        Especialidad espObj = new Especialidad(esp);
                        nuevaEspecialidad.add(espObj);
                    }
                }
                //String idmed, ArrayList<Especialidad> especialidad, String residente, String cargo, String tipocargo, int salario, String nombre, String doc, String nacimiento
                Medicos nuevoMedico = new Medicos(campos[6], nuevaEspecialidad, campos[7], campos[0], campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], campos[5]);

                lista.add(nuevoMedico);
            }
        }

        return lista;
    }
}
