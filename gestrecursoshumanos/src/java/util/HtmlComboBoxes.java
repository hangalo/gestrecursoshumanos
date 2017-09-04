/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.sun.prism.j2d.J2DPipeline;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HtmlComboBoxes extends Conexao{
    
    public HtmlComboBoxes(){ }
    
    /**
     * Constrói uma combo HTML (SELECT) a partir de uma tabela da BD.
     * @param tabela Nome da tabela da BD.
     * @param formulario Nome do formulário HTML.
     * @param nome Nome da combo box.
     * @param value Campo da tabela para o atributo 'value' das OPTION.
     * @param label Campo da tabela para o 'label' das OPTION.
     * @param evento Evento Javascript da combo box (opcional).
     *              Se não houver eventos, este parâmetro deve conter uma string vazia.
     * @param valorSeleccionado Valor seleccionado por defeito na combo
     *                          (pode ser utilizado em formulários de UPDATE).
     *                          Se não houver valor seleccionado por defeito, este parâmetro deve estar nulo.
     * @throws Exception Caso ocorra algum erro de SQL.
     * @return String com código HMTL da combo box.
     */
    
    public String select(String tabela,
            String formulario,
            String nome,
            String value,
            String label,
            String evento,
            String valorSeleccionado) throws Exception
    {
        //conectarBD();
        Conexao.getConnection();
        
        //abrir a tag select
        StringBuffer html = new StringBuffer("<select name='" + nome + "' " +
                "id='" + nome + "' " + evento + ">\n");

        
        //adicionar uma option vazia
        html.append("<option value=\"\">-- escolha --</option>\n");
            

        //efectuar a consulta SQL para seleccionar todos os registos da tabela
        PreparedStatement stm =  (PreparedStatement) Conexao.getConnection().prepareStatement("SELECT * FROM " + tabela + " ORDER BY " + label);

        ResultSet resultSet = stm.executeQuery();

        //para cada registo seleccionado, gerar um OPTION
        while (resultSet.next())
        {
            String option = "<option value='" + resultSet.getString(value) + "'";
            if (resultSet.getString(value).equalsIgnoreCase(valorSeleccionado))
                option += "selected ";
            option += ">" + resultSet.getString(label) + "</option>\n";
            html.append(option);

            
        }

        //fechar o cursor
        resultSet.close();
        stm.close();
       
        //fechar a tag select
        html.append("</select>\n\n");

        //se  houver um valor seleccionado por defeito
//        if (valorSeleccionado != null)
//        {
//            html.append("<script language='javascript'>" +
//                    formulario + "." + nome + ".value=" + valorSeleccionado +
//                    
//                    "</script>\n");
//        }

        //        fecharConexao();
        return html.toString();
    }
    
    /**
     * Constrói uma combo HTML (SELECT) a partir de uma tabela da BD, que depende de outra combo.
     * @param tabela Nome da tabela da BD.
     * @param formulario Nome do formulário HTML.
     * @param arrayJavascript Nome do array javascript que será criado para armazenar os itens da tabela.
     * @param comboAnterior Nome da combo anterior, da qual esta depende.
     * @param nome Nome da combo box.
     * @param value Campo da tabela para o atributo 'value' das OPTION.
     * @param label Campo da tabela para o 'label' das OPTION.
     * @param campoRelacionado Nome do campo relacionado, ou seja, chave estrangeira proveniente da tabela pai.
     * @param evento Evento Javascript da combo box (opcional).
     * @param valorSeleccionado Valor seleccionado por defeito na combo (pode ser utilizado em formulários de UPDATE).
     * @throws Exception Caso ocorra algum erro de SQL.
     * @return String com código HMTL da combo box.
     */
    public String selectDependente(String tabela,
            String formulario,
            String arrayJavascript,
            String comboAnterior,
            String nome,
            String value,
            String label,
            String campoRelacionado,
            String evento,
            String valorSeleccionado) throws Exception
    {
//        conectarBD();
        Conexao.getConnection();
        
        StringBuffer html = new StringBuffer("");
            html.append("<select name='" + nome + "' " + "id='" + nome + "' " + evento + ">\n");
        
        //adicionar uma opção vazia e fechar a tag select
        if (valorSeleccionado == null)
            html.append("<option value=\"\">-- escolha --</option></select>\n");

        //efectuar a consulta SQL para seleccionar todos os registos da tabela
        PreparedStatement stm = (PreparedStatement) Conexao.getConnection().prepareStatement("SELECT * FROM " + tabela + " ORDER BY " + label);

        ResultSet resultSet = stm.executeQuery();

        //declarar os arrays javascript
        html.append("<script>\n");

        html.append("var " + arrayJavascript + "Text" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Relac" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Value" + " = new Array();\n");
        html.append("\n");

        //Código do item pai seleccionado. Utilizado apenas se o valor seleccionado não for nulo.
        String codigoPaiSeleccionado = null;

        //índice dos arrays javascript
        int i = 0;

        //para cada registo seleccionado, gerar um OPTION
        while (resultSet.next())
        {

            String designacao = resultSet.getString(label);
            String codigoPai = resultSet.getString(campoRelacionado);
            String codigo = resultSet.getString(value);
            
            //se este for o item seleccionado, fixa o código do item pai para seleccionar na combo anterior
            if (codigo.equals(valorSeleccionado))
            {
                codigoPaiSeleccionado = codigoPai;

            //adicionar um elemento a cada um dos arrays javascript
            }
            html.append("" + arrayJavascript + "Text" + "[" + i + "] = \"" +
                    designacao + "\";\n");
            html.append("" + arrayJavascript + "Relac" + "[" + i + "] = " +
                    codigoPai + ";\n");
            html.append("" + arrayJavascript + "Value" + "[" + i + "] = " +
                    codigo + ";\n");

            i++;
        }

        //se houver um valor seleccionado por defeito
//        if (valorSeleccionado != null)
//        {
//            //seleccionar o valor da combo anterior com o codigo pai seleccionado
//            html.append(formulario + "." + comboAnterior +
//                    ".value = " + codigoPaiSeleccionado + ";\n");
//
//            //chamar a função JS que altera os itens da combo em função ao valor seleccionado na combo anterior
//            html.append("selectChange(" + formulario + "." + comboAnterior +
//                    ", " + formulario + "." + nome + ", " + arrayJavascript +
//                    "Text" + ", " + arrayJavascript + "Relac" + ", " + arrayJavascript +
//                    "Value" + ");\n");
//
//            //seleccionar o valor por defeito na combo
//            html.append(formulario + "." + nome +
//                    ".value = " + valorSeleccionado + ";\n");
//
//        }

        //fechar a tag <script>
        html.append("</script>\n");

        //fechar o cursor
        resultSet.close();
        stm.close();
//        fecharConexao();
        
        return html.toString();
    }
    
    /**
     * Constrói uma combo HTML (SELECT) a partir de uma tabela da BD, que depende de outra combo.
     * @param tabela Nome da tabela da BD.
     * @param formulario Nome do formulário HTML.
     * @param arrayJavascript Nome do array javascript que será criado para armazenar os itens da tabela.
     * @param comboAnterior Nome da combo anterior, da qual esta depende.
     * @param nome Nome da combo box.
     * @param value Campo da tabela para o atributo 'value' das OPTION.
     * @param label Campo da tabela para o 'label' das OPTION.
     * @param campoRelacionado Nome do campo relacionado, ou seja, chave estrangeira proveniente da tabela pai.
     * @param evento Evento Javascript da combo box (opcional).
     * @param valorSeleccionado Valor seleccionado por defeito na combo (pode ser utilizado em formulários de UPDATE).
     * @throws Exception Caso ocorra algum erro de SQL.
     * @return String com código HMTL da combo box.
     */
    public String selectDependente(String tabela,
            String formulario,
            String arrayJavascript,
            String comboAnterior,
            String nome,
            String value,
            String label,
            String campoRelacionado,
            String evento,
            String valorSeleccionado,
            String valorActivo) throws Exception
    {
//        conectarBD();
        Conexao.getConnection();
        
        StringBuffer html = new StringBuffer("");
        //abrir a tag select

        String options ="<select name='" + nome + "' " + "id='" + nome + "' " + evento + ">\n";
        

        //efectuar a consulta SQL para seleccionar todos os registos da tabela
        PreparedStatement stm = (PreparedStatement) Conexao.getConnection().prepareStatement("SELECT * FROM " + tabela + " ORDER BY " + label);

        ResultSet resultSet = stm.executeQuery();

        //declarar os arrays javascript
        html.append("<script>\n");

        html.append("var " + arrayJavascript + "Text" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Relac" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Value" + " = new Array();\n");
        html.append("\n");

        //Código do item pai seleccionado. Utilizado apenas se o valor seleccionado não for nulo.
        String codigoPaiSeleccionado = null;

        //índice dos arrays javascript
        int i = 0;

        //para cada registo seleccionado, gerar um OPTION
        while (resultSet.next())
        {

            String designacao = resultSet.getString(label);
            String codigoPai = resultSet.getString(campoRelacionado);
            String codigo = resultSet.getString(value);

            
            if (codigoPai.equalsIgnoreCase(valorSeleccionado))
            {
                if (codigo.equalsIgnoreCase(valorActivo))
                    options += "<option  selected value=\"";
                else
                    options += "<option value=\"";

                options += codigo +"\">" + designacao + "</option>\n";
            }
            //se este for o item seleccionado, fixa o código do item pai para seleccionar na combo anterior
            if (codigo.equals(valorSeleccionado))
            {
                codigoPaiSeleccionado = codigoPai;

            //adicionar um elemento a cada um dos arrays javascript
            }
            html.append("" + arrayJavascript + "Text" + "[" + i + "] = \"" +
                    designacao + "\";\n");
            html.append("" + arrayJavascript + "Relac" + "[" + i + "] = " +
                    codigoPai + ";\n");
            html.append("" + arrayJavascript + "Value" + "[" + i + "] = " +
                    codigo + ";\n");

            i++;
        }

        options += "</select>\n";
        //se houver um valor seleccionado por defeito
//        if (valorSeleccionado != null)
//        {
//            //seleccionar o valor da combo anterior com o codigo pai seleccionado
//            html.append(formulario + "." + comboAnterior +
//                    ".value = " + codigoPaiSeleccionado + ";\n");
//
//            //chamar a função JS que altera os itens da combo em função ao valor seleccionado na combo anterior
//            html.append("selectChange(" + formulario + "." + comboAnterior +
//                    ", " + formulario + "." + nome + ", " + arrayJavascript +
//                    "Text" + ", " + arrayJavascript + "Relac" + ", " + arrayJavascript +
//                    "Value" + ");\n");
//
//            //seleccionar o valor por defeito na combo
//            html.append(formulario + "." + nome +
//                    ".value = " + valorSeleccionado + ";\n");
//
//        }

        //fechar a tag <script>
        html.append("</script>\n");

        //fechar o cursor
        resultSet.close();
        stm.close();
//        fecharConexao();
        return options + html.toString();
    }
    
    /**
     * Constrói uma combo HTML (SELECT) a partir de uma tabela da BD, que depende de outra combo.
     * Este método deve ser usado com relacionamentos n para m ( n...m ).
     * @param tabela Nome da tabela da BD.
     * @param joinTable Nome da tabela com que a primeira ira fazer o JOIN.
     * @param formulario Nome do formulário HTML.
     * @param arrayJavascript Nome do array javascript que será criado para armazenar os itens da tabela.
     * @param comboAnterior Nome da combo anterior, da qual esta depende.
     * @param nome Nome da combo box.
     * @param value Campo da tabela para o atributo 'value' das OPTION.
     * @param value Campo da tabela de união em que é realizado o INNER JOIN
     * @param label Campo da tabela para o 'label' das OPTION.
     * @param campoRelacionado Nome do campo relacionado, ou seja, chave estrangeira proveniente da tabela pai.
     * @param evento Evento Javascript da combo box (opcional).
     * @param valorSeleccionado Valor seleccionado por defeito na combo (pode ser utilizado em formulários de UPDATE).
     * @throws Exception Caso ocorra algum erro de SQL.
     * @return String com código HMTL da combo box.
     */
    public String selectDependente(String tabela,
            String joinTable,
            String formulario,
            String arrayJavascript,
            String comboAnterior,
            String nome,
            String value,
            String joinValue,
            String label,
            String campoRelacionado,
            String evento,
            String valorSeleccionado) throws Exception
    {
//        conectarBD();
        Conexao.getConnection();
        //abrir a tag select
        StringBuffer html = new StringBuffer("<select name='" + nome + "' " +
                "id='" + nome + "' " + evento + ">\n");

        //adicionar uma opção vazia e fechar a tag select
        html.append("<option value=\"\">-- escolha --</option></select>\n");

        //efectuar a consulta SQL para seleccionar todos os registos da tabela
        PreparedStatement stm = (PreparedStatement) Conexao.getConnection().prepareStatement("SELECT * FROM " +
                tabela + ", " + joinTable + " WHERE " + tabela + "." + value +
                " = " + joinTable + "." + joinValue +" ORDER BY " + label);

        ResultSet resultSet = stm.executeQuery();

        //declarar os arrays javascript
        html.append("<script>\n");

        html.append("var " + arrayJavascript + "Text" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Relac" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Value" + " = new Array();\n");
        html.append("\n");

        //Código do item pai seleccionado. Utilizado apenas se o valor seleccionado não for nulo.
        String codigoPaiSeleccionado = null;

        //índice dos arrays javascript
        int i = 0;

        //para cada registo seleccionado, gerar um OPTION
        while (resultSet.next())
        {

            String designacao = resultSet.getString(label);
            String codigoPai = resultSet.getString(campoRelacionado);
            String codigo = resultSet.getString(value);

            //se este for o item seleccionado, fixa o código do item pai para seleccionar na combo anterior
            if (codigo.equals(valorSeleccionado))
            {
                codigoPaiSeleccionado = codigoPai;

            //adicionar um elemento a cada um dos arrays javascript
            }
            html.append("" + arrayJavascript + "Text" + "[" + i + "] = \"" +
                    designacao + "\";\n");
            html.append("" + arrayJavascript + "Relac" + "[" + i + "] = " +
                    codigoPai + ";\n");
            html.append("" + arrayJavascript + "Value" + "[" + i + "] = " +
                    codigo + ";\n");

            i++;
        }

        //se houver um valor seleccionado por defeito
        if (valorSeleccionado != null)
        {
            //seleccionar o valor da combo anterior com o codigo pai seleccionado
            html.append(formulario + "." + comboAnterior +
                    ".value = " + codigoPaiSeleccionado + ";\n");

            //chamar a função JS que altera os itens da combo em função ao valor seleccionado na combo anterior
            html.append("selectChange(" + formulario + "." + comboAnterior +
                    ", " + formulario + "." + nome + ", " + arrayJavascript +
                    "Text" + ", " + arrayJavascript + "Relac" + ", " + arrayJavascript +
                    "Value" + ");\n");

            //seleccionar o valor por defeito na combo
            html.append(formulario + "." + nome +
                    ".value = " + valorSeleccionado + ";\n");
        }

        //fechar a tag <script>
        html.append("</script>\n");

        //fechar o cursor
        resultSet.close();
        stm.close();
//        fecharConexao();
        

        return html.toString();
    }
    
    //-------------------------------------------------------------------------------------------------------

    /**
     * Constrói uma combo HTML (SELECT) a partir de uma tabela da BD, que depende de outra combo.
     * Este método deve ser usado com relacionamentos n para m ( n...m ).
     * @param tabela Nome da tabela da BD.
     * @param joinTable Nome da tabela com que a primeira ira fazer o JOIN.
     * @param formulario Nome do formulário HTML.
     * @param arrayJavascript Nome do array javascript que será criado para armazenar os itens da tabela.
     * @param comboAnterior Nome da combo anterior, da qual esta depende.
     * @param nome Nome da combo box.
     * @param value Campo da tabela para o atributo 'value' das OPTION.
     * @param value Campo da tabela de união em que é realizado o INNER JOIN
     * @param label1 Primeiro campo da tabela para o 'label' das OPTION.
     * @param label2 Segundo campo da tabela para o 'label' das OPTION.
     * @param label3 Terceiro campo da tabela para o 'label' das OPTION.
     * @param campoRelacionado Nome do campo relacionado, ou seja, chave estrangeira proveniente da tabela pai.
     * @param evento Evento Javascript da combo box (opcional).
     * @param valorSeleccionado Valor seleccionado por defeito na combo (pode ser utilizado em formulários de UPDATE).
     * @throws Exception Caso ocorra algum erro de SQL.
     * @return String com código HMTL da combo box.
     */
    public String selectDependente(String tabela,
            String joinTable,
            String formulario,
            String arrayJavascript,
            String comboAnterior,
            String nome,
            String value,
            String joinValue,
            String label1,
            String label2,
            String label3,
            String campoRelacionado,
            String evento,
            String valorSeleccionado) throws Exception
    {

        System.out.println("SELECT * FROM " +
                tabela + ", " + joinTable + " WHERE " + tabela + "." + value +
                " = " + joinTable + "." + joinValue +" ORDER BY " + tabela + "." +
                label1 );
        
//        conectarBD();
         Conexao.getConnection();
        //abrir a tag select
        StringBuffer html = new StringBuffer("<select name='" + nome + "' " +
                "id='" + nome + "' " + evento + ">\n");

        //adicionar uma opção vazia e fechar a tag select
        html.append("<option value=\"\">-- escolha --</option></select>\n");

        //efectuar a consulta SQL para seleccionar todos os registos da tabela
        PreparedStatement stm = (PreparedStatement) Conexao.getConnection().prepareStatement("SELECT * FROM " +
                tabela + ", " + joinTable + " WHERE " + tabela + "." + value +
                " = " + joinTable + "." + joinValue +" ORDER BY " + tabela + "." +
                label1 );
        
        ResultSet resultSet = stm.executeQuery();

        //declarar os arrays javascript
        html.append("<script>\n");

        html.append("var " + arrayJavascript + "Text" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Relac" + " = new Array();\n");
        html.append("var " + arrayJavascript + "Value" + " = new Array();\n");
        html.append("\n");

        //Código do item pai seleccionado. Utilizado apenas se o valor seleccionado não for nulo.
        String codigoPaiSeleccionado = null;

        //índice dos arrays javascript
        int i = 0;

        //para cada registo seleccionado, gerar um OPTION
        while (resultSet.next())
        {

            String designacao = resultSet.getString(label1) + "/" + resultSet.getString(
                    label2) + "/" + resultSet.getString(label3);
            String codigoPai = resultSet.getString(campoRelacionado);
            String codigo = resultSet.getString(value);

            //se este for o item seleccionado, fixa o código do item pai para seleccionar na combo anterior
            if (codigo.equals(valorSeleccionado))
            {
                codigoPaiSeleccionado = codigoPai;

            //adicionar um elemento a cada um dos arrays javascript
            }
            html.append("" + arrayJavascript + "Text" + "[" + i + "] = \"" +
                    designacao + "\";\n");
            html.append("" + arrayJavascript + "Relac" + "[" + i + "] = " +
                    codigoPai + ";\n");
            html.append("" + arrayJavascript + "Value" + "[" + i + "] = " +
                    codigo + ";\n");

            i++;
        }

        //se houver um valor seleccionado por defeito
        if (valorSeleccionado != null)
        {
            //seleccionar o valor da combo anterior com o codigo pai seleccionado
            html.append(formulario + "." + comboAnterior +
                    ".value = " + codigoPaiSeleccionado + ";\n");

            //chamar a função JS que altera os itens da combo em função ao valor seleccionado na combo anterior
            html.append("selectChange(" + formulario + "." + comboAnterior +
                    ", " + formulario + "." + nome + ", " + arrayJavascript +
                    "Text" + ", " + arrayJavascript + "Relac" + ", " + arrayJavascript +
                    "Value" + ");\n");

            //seleccionar o valor por defeito na combo
            html.append(formulario + "." + nome +
                    ".value = " + valorSeleccionado + ";\n");
        }

        //fechar a tag <script>
        html.append("</script>\n");

        //fechar o cursor
        resultSet.close();
        stm.close();
//        fecharConexao();
        
        
        return html.toString();
    }
}
