package textfiles;

import java.io.File;
import java.io.IOException;

public class BPELFilter {
    
    private File file;

    public BPELFilter (File fileName) {
        file=fileName;
    }
    
public String filterBPEL() {
    StringBuffer OutputText = new StringBuffer();
    
        try{
            String bpel_name = file.getName();
            String file_path = file.getAbsolutePath();
            StringBuffer IncorrectNamespace = new StringBuffer();
            StringBuffer NameErrorDisplay = new StringBuffer();
            StringBuffer Assigns = new StringBuffer("       Assign Names:\n");
            StringBuffer Scopes = new StringBuffer("       Scope Names:\n");
            StringBuffer Invokes = new StringBuffer("       Invoke Names:\n");
            StringBuffer Mappings = new StringBuffer("       Mapping Names:\n");
            ReadFile textFile=new ReadFile (file_path);
            String[] aryLines = textFile.OpenFile();
            WordCounter countWords= new  WordCounter();
            RegexModule Regex = new RegexModule();
            
            //Check BPEL Name
            if (countWords.countCapitals(bpel_name)> 9){
                NameErrorDisplay.append("   - This BPEL's name does not follow the correct naming standard because the words in the name are greater than 4 (");
                NameErrorDisplay.append(countWords.countCapitals(bpel_name));
                NameErrorDisplay.append(" words).");
            }
            
            int i;
            
            for ( i=0; i < aryLines.length; i++ ) {
                //Check Namespace
                
                if ((Regex.regexContains("^(<definitions)?.?targetnamespace=\"", aryLines[i].toLowerCase().trim()) == true) && (Regex.regexContains("http://www.americanexpress.com", aryLines[i]) == false)){
                    IncorrectNamespace.append("       " + aryLines[i].trim() + "\n");
                    }
                
                //Check Assigns
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 1\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign1\"")){
                    Assigns.append("\t" + aryLines[i].trim() + " - at line " +(i+1) + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 2\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign2\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 3\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign3\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 4\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign4\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 5\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign5\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 6\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign6\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 7\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign7\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 8\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign8\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"assign 9\"")|| aryLines[i].toLowerCase().contains("<assign name=\"assign9\"")){
                    Assigns.append("\t" + aryLines[i].trim() + "\n");
                }
                
                //Check Transforms
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 1\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform1\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 2\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform2\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 3\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform3\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 4\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform4\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 5\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform5\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 6\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform6\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 7\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform7\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 8\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform8\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<assign name=\"transform 9\"")|| aryLines[i].toLowerCase().contains("<assign name=\"transform9\"")){
                    Mappings.append("\t" + aryLines[i].trim() + "\n");
                }
                
                //Check Scopes
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 1\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope1\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 2\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope2\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 3\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope3\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 4\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope4\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 5\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope5\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 6\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope6\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 7\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope7\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 8\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope8\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<scope name=\"scope 9\"")|| aryLines[i].toLowerCase().contains("<scope name=\"scope9\"")){
                    Scopes.append("\t" + aryLines[i].trim() + "\n");
                }
                
                //Check Invokes
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 1\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke1\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 2\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke2\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 3\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke3\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 4\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke4\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 5\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke5\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 6\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke6\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 7\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke7\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 8\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke8\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
                if (aryLines[i].toLowerCase().contains("<invoke name=\"invoke 9\"")|| aryLines[i].toLowerCase().contains("<invoke name=\"invoke9\"")){
                    Invokes.append("\t" + aryLines[i].trim() + "\n");
                }
        
            }
            //Result Printing
            if ((Assigns.length() > 21)||(Scopes.length() > 20)||(Mappings.length() > 22)||(Invokes.length() > 22)||(NameErrorDisplay.length() > 0)||(IncorrectNamespace.length() > 0)){
                StringBuffer PathDisplay = new StringBuffer(file_path);
                OutputText.append(PathDisplay + "\n");
                
                if (IncorrectNamespace.length() > 0){
                    OutputText.append("   - This BPEL contains an improper namespace:\n       " + IncorrectNamespace + "\n");
                    }
                if (NameErrorDisplay.length() > 0){
                    OutputText.append(NameErrorDisplay + "\n");
                    }
                if ((Assigns.length() > 21)||(Scopes.length() > 20)||(Mappings.length() > 22)||(Invokes.length() > 22)){
                    StringBuffer InteriorDisplay = new StringBuffer("   - This BPEL contains the followig non-standard items:\n");
                    if (Assigns.length() > 21){
                        InteriorDisplay.append(Assigns);
                    }
                    if (Scopes.length() > 20){
                        InteriorDisplay.append(Scopes);
                        }
                    if (Mappings.length() > 22){
                        InteriorDisplay.append(Mappings);
                        }
                    if (Invokes.length() > 22){
                        InteriorDisplay.append(Invokes);
                        }
                    OutputText.append(InteriorDisplay + "\n");
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