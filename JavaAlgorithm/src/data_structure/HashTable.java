package data_structure;

public class HashTable {
    public Slot[] hashTable;

    public HashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            this.hashTable[address].value = value;
        }else{
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = hashFunc(key);
        if(this.hashTable[address] != null){
            return this.hashTable[address].value;
        }else{
            return null;
        }
    }

//     public boolean saveData(String key, String value) {
//         Integer address = this.hashFunc(key);
//         if (this.hashTable[address] != null) {
//             this.hashTable[address].value = value;
//         } else {
//             this.hashTable[address] = new Slot(value);
//         }
//         return true;
//     }
}