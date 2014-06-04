//If you want to clear the object's attributes, use the clearAttributes() method. Don't set the attributes to null.
import java.util.ArrayList;
public class TreeObject
{
    String _name;
    ArrayList<Integer> _attributes;

    public TreeObject()
    {
	_name = "Null";
	_attributes = new ArrayList<Integer>();
    }
    public TreeObject(String nameInput, ArrayList<Integer> attributesInput)
    {
	_name = nameInput;
	_attributes = attributesInput;
    }
    public ArrayList<Integer> getAttributes()
    {
	return _attributes;
    }
    public int getAttributeAt( int index){
	return _attributes.get(index);
    }
    public String getName()
    {
	return _name;
    }

    public ArrayList<Integer> setAttributes(ArrayList<Integer> attributesInput)
    {
	ArrayList<Integer> oldAtr = _attributes;
	_attributes = attributesInput;
	return oldAtr;
    }

    public ArrayList<Integer> clearAttributes()
    {
	ArrayList<Integer> oldAtr = _attributes;
	_attributes = new ArrayList<Integer>();
	return oldAtr;
    }

    public String toString()
    {
	String returnString = "";
	returnString = "|Name:" + _name + ",Attributes:" + _attributes + "|";
	return returnString;
    }

}