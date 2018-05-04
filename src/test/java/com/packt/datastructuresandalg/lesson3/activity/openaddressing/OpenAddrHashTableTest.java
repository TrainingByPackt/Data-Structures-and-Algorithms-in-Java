package com.packt.datastructuresandalg.lesson3.activity.openaddressing;

import com.packt.datastructuresandalg.lesson3.hashtable.RemainderHashing;
import junit.framework.TestCase;

import java.util.Optional;

public class OpenAddrHashTableTest extends TestCase {

    public void testEmptyHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        assertEquals(Optional.empty(), hashTable.get(123));
    }

    public void testItemExistHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(5, "Test");
        assertEquals(Optional.of("Test"), hashTable.get(5));
    }

    public void testItemExistAfterCollisionHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(5, "Test1");
        hashTable.put(15, "Test2");
        assertEquals(Optional.of("Test1"), hashTable.get(5));
        assertEquals(Optional.of("Test2"), hashTable.get(15));
    }

    public void testItemOnOccupiedSlotHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(5, "Test5");
        hashTable.put(15, "Test15");
        hashTable.put(6, "Test6");
        assertEquals(Optional.of("Test6"), hashTable.get(6));
    }

    public void testGetItemAfterRemove() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(5, "Test5");
        hashTable.put(15, "Test15");
        hashTable.put(6, "Test6");
        hashTable.remove(6);
        assertEquals(Optional.empty(), hashTable.get(6));
    }

    public void testInsertItemAfterRemove() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(5, "Test5");
        hashTable.put(15, "Test15");
        hashTable.put(6, "Test6");
        hashTable.remove(6);
        hashTable.put(25, "Test25");
        assertEquals(Optional.of("Test25"), hashTable.get(25));
    }


    public void testItemWrapsAroundHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(8, "Test8");
        hashTable.put(18, "Test18");
        hashTable.put(28, "Test28");
        hashTable.put(38, "Test38");
        hashTable.put(48, "Test48");
        hashTable.put(9, "Test9");
        hashTable.put(19, "Test19");
        hashTable.put(0, "Test0");
        assertEquals(Optional.of("Test8"), hashTable.get(8));
        assertEquals(Optional.of("Test18"), hashTable.get(18));
        assertEquals(Optional.of("Test28"), hashTable.get(28));
        assertEquals(Optional.of("Test38"), hashTable.get(38));
        assertEquals(Optional.of("Test48"), hashTable.get(48));
        assertEquals(Optional.of("Test9"), hashTable.get(9));
        assertEquals(Optional.of("Test19"), hashTable.get(19));
        assertEquals(Optional.of("Test0"), hashTable.get(0));
        assertEquals(Optional.empty(), hashTable.get(58));
    }

    public void testRemoveItemWrapsAroundHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(8, "Test8");
        hashTable.put(18, "Test18");
        hashTable.put(28, "Test28");
        hashTable.put(38, "Test38");
        hashTable.put(48, "Test48");
        hashTable.put(9, "Test9");
        hashTable.put(19, "Test19");
        hashTable.put(0, "Test0");
        hashTable.remove(9);
        hashTable.put(58, "Test58");
        assertEquals(Optional.empty(), hashTable.get(9));
        assertEquals(Optional.of("Test0"), hashTable.get(0));
        assertEquals(Optional.of("Test58"), hashTable.get(58));
    }


    public void testSearchItemOnFullHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(2, "Test2");
        hashTable.put(12, "Test12");
        hashTable.put(22, "Test22");
        hashTable.put(32, "Test32");
        hashTable.put(42, "Test42");
        hashTable.put(52, "Test52");
        hashTable.put(62, "Test62");
        hashTable.put(72, "Test72");
        hashTable.put(82, "Test82");
        hashTable.put(92, "Test92");
        assertEquals(Optional.empty(), hashTable.get(102));
    }

    public void testPutItemOnFullHashTable() {
        OpenAddrHashTable<Integer, String> hashTable = new OpenAddrHashTable<>(10, new RemainderHashing());
        hashTable.put(1, "Test1");
        hashTable.put(11, "Test11");
        hashTable.put(21, "Test21");
        hashTable.put(31, "Test31");
        hashTable.put(41, "Test41");
        hashTable.put(51, "Test51");
        hashTable.put(61, "Test61");
        hashTable.put(71, "Test71");
        hashTable.put(81, "Test81");
        hashTable.put(91, "Test91");
        hashTable.put(101, "Test101");
        assertEquals(Optional.empty(), hashTable.get(101));
        assertEquals(Optional.of("Test1"), hashTable.get(1));
    }



}
