/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author informatica
 */
public class DateUtil {

    public static Date strToDate(String data) {
        if (data == null) {
            return null;
        }

        Date dataF = null;
        try {
            DateFormat dateFormat;
            if(data.indexOf('-') >= 0)
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            else
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            long timestamp = dateFormat.parse(data).getTime();
            dataF = new Date(timestamp);
        } catch (ParseException pe) {
            System.err.println("Erro ao converter String em data: " + pe.getLocalizedMessage());
        }
        return dataF;
    }

    public static String formataData(Date data) {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        calendar.setTime(data);
        return sdf.format(calendar.getTime());
    }
    
     public static String getDataActual (){
        String dataString = "";
        Date data = new Date (System.currentTimeMillis());
        SimpleDateFormat formatDate = new SimpleDateFormat ("dd/MM/yyyy");
        dataString += formatDate.format(data);
        return dataString;
    }
}
