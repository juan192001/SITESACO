package SITESACO;
//clase hoja

import java.util.ArrayList;
import javax.swing.JOptionPane;

//Empleados clase hija de la clase padre Persona
public class Empleados extends Persona {
    //Atributos ˙nicos de empleados

    protected String cargo;
    protected String tipocargo;
    protected int salario;

//Constructor
    public Empleados(String cargo, String tipocargo, int salario, String nombre, String doc, String nacimiento) {
        super(nombre, doc, nacimiento);
        this.cargo = cargo;
        this.tipocargo = tipocargo;
        this.salario = salario;
    }

    public Empleados() {
        super("", "", "");
    }
//MÈtodos getters y setters

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipocargo() {
        return tipocargo;
    }

    public void setTipocargo(String tipocargo) {
        this.tipocargo = tipocargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

//MÈtodos sobreescritos
    @Override
    public void agregarPersona() {
        //Input del usuario para los atributos del empleado
        String esmedico = JOptionPane.showInputDialog("Deseas registrar un mÈdico si o no ");
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre completo del empleado ");
        this.doc = JOptionPane.showInputDialog("Ingrese el documento de identidad ");
        this.nacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento ");
        this.cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado ");
        this.salario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario del empleado "));
        if (esmedico.equalsIgnoreCase("si")) {
            this.tipocargo = "medico";
        } else {
            this.tipocargo = JOptionPane.showInputDialog("Ingrese el tipo de cargo del empleado ");
        }

    }

    @Override
    public void verLista(ArrayList<Persona> empleados) {
        //Un for each para mostrar todos los pacientes en el ArrayList empleados
                System.out.println("LISTA DE EMPLEADOS");
        for (Persona emp : empleados) {
            Empleados emp1 = (Empleados) emp;
            System.out.println("Nombre: \n" + emp.getNombre() + "\nDocumento de identidad: \n" + emp.getDoc()
                    + "\nCargo del empleado: \n" + emp1.cargo + "\n====================================================================");
        }
    }

    @Override
    public void verDetalles() {
        //MÈtodo para imprimir todos los atributos de un empleado
        System.out.println("Nombre: \n" + this.getNombre() + "\nDocumento de identidad: \n" + this.getDoc() + "\nFecha de nacimiento: \n" + this.getNacimiento()
                + "\nCargo del empleado: \n" + this.getCargo() + "\nTipo de cargo: \n" + this.getTipocargo() + "\nSalario: \n"
                + this.getSalario() + "\n====================================================================");
    }

    @Override
    public void Eliminar(ArrayList<Persona> empleados) {
        //MÈtodo para eliminar un empleado
        //Busca el empleado que se quiere eliminar
        Persona enconemp = buscar(empleados);
        if (enconemp != null) {
            //Remueve el empleado del ArrayList
            empleados.remove(enconemp);
            JOptionPane.showMessageDialog(null,"Empleado eliminado con Èxito");
        } else {
            JOptionPane.showMessageDialog(null,"No existe ese empleado");

        }
    }

    @Override
    public Persona buscar(ArrayList<Persona> persona) {
        //MÈtodo para buscar a un empleado mediente su documento de identidad
        String cedula = JOptionPane.showInputDialog("Ingrese el n˙mero de documento de identidad del empleado a buscar");
        for (Persona per : persona) {
            if (per.getDoc().equals(cedula)) {
                return per;
            }
        }
        return null;
    }
    public static ArrayList<Persona> convertirTXTaObjetos(String txtEmpleados) {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        // Iterar la linea , separada por #
        String[] empleados = txtEmpleados.split("#");
        for (int i = 1; i < empleados.length; i++) {
            String emp = empleados[i];

            // iterar atributos de empleados
            String[] campos = emp.split(",");
            // Crear persona
//			Persona nuevaPersona = new Empleados(cargo, tipocargo, salario, nombre, doc, nacimiento);
            if (campos[0] != null && campos[0].equals("medico") == false) { // carga en la lista a todos excepto al medico
                Persona nuevaPersona = new Empleados(campos[0], campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], campos[5]);
                lista.add(nuevaPersona);
            }
        }

        return lista;
    }
}


