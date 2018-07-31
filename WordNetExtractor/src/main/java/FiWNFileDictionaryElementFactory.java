import net.sf.extjwnl.princeton.data.PrincetonWN17FileDictionaryElementFactory;
import net.sf.extjwnl.data.*;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.util.factory.Param;

import java.util.Map;

public class FiWNFileDictionaryElementFactory extends PrincetonWN17FileDictionaryElementFactory
{
    public FiWNFileDictionaryElementFactory(Dictionary dictionary, Map<String, Param> params) {
        super(dictionary, params);
    }

    protected Word createWord(Synset synset, String lemma) {
	String cleaned = lemma.trim();
	if (cleaned.endsWith(">")) {
	    int tagStart = cleaned.indexOf('<');
	    if (tagStart > 0) {
		cleaned = cleaned.substring(0, tagStart).trim();
	    }
	}
	return super.createWord(synset, cleaned);
    }
}
