package textfiles;

import java.io.File;
import java.io.IOException;

public class XSDFilter {
    
    private File file;

    public XSDFilter (File fileName) {
        file=fileName;
    }
    
public String filterXSD() {
    StringBuffer OutputText = new StringBuffer();
    
    try{ 
        String bpel_name = file.getName();
        String file_path = file.getAbsolutePath();
        StringBuffer NameErrorDisplay = new StringBuffer();
        StringBuffer IncorrectNamespace = new StringBuffer();
        ReadFile textFile=new ReadFile (file_path);
        String[] aryLines = textFile.OpenFile();
        WordCounter countWords= new  WordCounter();
        RegexModule Regex = new RegexModule();
        
        //Check XSD Name
        if (countWords.countCapitals(bpel_name)> 9){
            NameErrorDisplay.append("   - This XSD's name does not follow the correct naming standard because the words in the name are greater than 4 (");
            NameErrorDisplay.append(countWords.countCapitals(bpel_name));
            NameErrorDisplay.append(" words).");
            }
        
        int i;
        
        for ( i=0; i < aryLines.length; i++ ) {
        
            //Check Namespace
            if ((Regex.regexContains("^(<definitions)?.?targetnamespace=\"", aryLines[i].toLowerCase().trim()) == true) && (Regex.regexContains("http://www.americanexpress.com", aryLines[i]) == false)){
                IncorrectNamespace.append("       " + aryLines[i].trim() + "\n");
                }
            }
        
        //Result Printing
        if ((NameErrorDisplay.length() > 0)||(IncorrectNamespace.length() > 0)){
            StringBuffer PathDisplay = new StringBuffer(file_path + "\n");
            OutputText.append(PathDisplay);
            if (IncorrectNamespace.length() > 0){
                OutputText.append("   - This XSD contains an improper namespace:\n       " + IncorrectNamespace + "\n");
                }
            if (NameErrorDisplay.length() > 0){
                OutputText.append(NameErrorDisplay);
                }
            }
        }
    catch (IOException e) {
        System.out.println( e.getMessage() );
        }
    String Output = OutputText.toString();
    return Output.trim();
    }
}