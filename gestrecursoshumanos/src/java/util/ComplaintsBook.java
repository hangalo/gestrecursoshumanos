/**
 *
 * @author Viv Mendes
 * Criei este ficheiro java para reportarem reclamaçoes, duvidas e erros encontrados
 * 
 * Todas entradas neste ficheiro deverao seguir a seguinte sintaxe:
 * 
 * NomeClasse ou tabela{
 *      
 *      nomeAtributo{ duvidas sobre a implementação...}
 *      
 *      nomeMetodo(){
 *          "Aqui vem as linhas do erro ou a duvida referente ao metodo se for possivel especificar a linha"
 *      }
 * }
 * 
 * As novas entradas neste ficheiro deverão ser postas logo a seguir ao ultimo metodo
 * 
 * Todas as entradas neste ficheiro poderão ser respondidas por qualquer individuo do grupo
 * Assim que uma entrada for revisada devera ser removida deste ficheiro de modo a manter apenas 
 * entradas não revisadas
 * 
 * 
 * OBS - 16/06/2017 - Joaquim José Hangalo
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 
 * >>>>(Rever)Guadar imagens
 * 
 * Ver na pagina 87 do manual
 * 
 * As variaveis devem ser declaradas da seguinte torma
 * 
 * private byte [] ficheiro
 * private String URLFicheiro;
 * 
 *  uma para guardar os bytes do ficheiro
 * outra o nome para eventual manipulação via url (localizacao externa do ficheiro)
 * 
 * >>> (Rever) LISTAR_TUDO e BUSCAR_POR_CODIGO
 * è necessario um INNER JOIN  no caso de tabelas (entidades) relacionadas
 * 
 * 
 * >>>(Rever) A Entidade empresa deveria ter um relacao com o Municipio (foi um erro nao ter definido esta relacao)... 
 * está definida no novo script
 * 
 * >> Realizar os testes unitarios
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * 
 * OBS - 25/07/2017 - Vivaldo Mendes Cândido
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 
 * >>>>(Implementacao)Processamento de imagem via servlet BD e ficheiro
 * 
 * De forma a ter um unico servlet para o processamento de imagens foi criado
 * o servlet VisualizaImagemServlet para que tal funcione a classe DAO da entidade em questao
 * deve implementar a interface FotoGenericDAO
 * 
 * o metodo de uso na pagina jsp nao difere da encontrada no livro pagina 95
 * 
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * 
 * * OBS - 04/08/2017 - Vivaldo Mendes Cândido
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 
 * >>>>(Implementacao)Erro ao executar paginas JSP
 * 
 * Prof. Estou a ter um erro estranho a executar algumas paginas jsp,
 * gostaria que o prof desse uma olhada e me desse um feedback sobre esta situação.
 * 
 * Ao executar a pagina web funcionario por exemplo emite o seguinte erro na consola: 
 * 
 *  javac: invalid flag: -Xmx512m
    Usage: javac <options> <source files>
    use -help for a list of possible options
    C:\Users\Viv Mendes\Documents\NetBeansProjects\gestrecursoshumanos\gestrecursoshumanos\nbproject\build-impl.xml:978: The following error occurred while executing this line:
    C:\Users\Viv Mendes\Documents\NetBeansProjects\gestrecursoshumanos\gestrecursoshumanos\nbproject\build-impl.xml:321: Compile failed; see the compiler error output for details.
    BUILD FAILED (total time: 1 second)
 * 
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

 */
