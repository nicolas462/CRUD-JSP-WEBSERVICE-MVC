
package pwebservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para medico complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="medico"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://PWebServices/}user"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="anosExp" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="especialidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="horaFin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="horaInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numTarjetaProf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medico", propOrder = {
    "anosExp",
    "especialidad",
    "horaFin",
    "horaInicio",
    "numTarjetaProf"
})
public class Medico
    extends User
{

    protected double anosExp;
    protected String especialidad;
    protected String horaFin;
    protected String horaInicio;
    protected String numTarjetaProf;

    /**
     * Obtiene el valor de la propiedad anosExp.
     * 
     */
    public double getAnosExp() {
        return anosExp;
    }

    /**
     * Define el valor de la propiedad anosExp.
     * 
     */
    public void setAnosExp(double value) {
        this.anosExp = value;
    }

    /**
     * Obtiene el valor de la propiedad especialidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Define el valor de la propiedad especialidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspecialidad(String value) {
        this.especialidad = value;
    }

    /**
     * Obtiene el valor de la propiedad horaFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     * Define el valor de la propiedad horaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraFin(String value) {
        this.horaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad horaInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Define el valor de la propiedad horaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraInicio(String value) {
        this.horaInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad numTarjetaProf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTarjetaProf() {
        return numTarjetaProf;
    }

    /**
     * Define el valor de la propiedad numTarjetaProf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTarjetaProf(String value) {
        this.numTarjetaProf = value;
    }

}
