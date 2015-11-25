package me.jacquelineabreu.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class SubsetSumTest {

    @Test
    public void testEmptySubset() throws Exception {
        PrintSubset print = mock(PrintSubset.class);
        SubsetSum sum = new SubsetSum(print);
        sum.subsetSum(0, new ArrayList<Integer>());
        verifyNoMoreInteractions(print);
    }

    @Test
    public void testEmptySubsetSumDifferent0() throws Exception {
        PrintSubset print = mock(PrintSubset.class);
        SubsetSum sum = new SubsetSum(print);
        sum.subsetSum(10, new ArrayList<Integer>());
        verifyNoMoreInteractions(print);
    }

    @Test
    public void test12346Subset6() throws Exception {
        PrintSubset print = mock(PrintSubset.class);
        SubsetSum sum = new SubsetSum(print);
        sum.subsetSum(6, Arrays.asList(1, 2, 3, 4, 6));
        verify(print).printSubset(Arrays.asList(1, 2, 3));
        verify(print).printSubset(Arrays.asList(2, 4));
        verify(print).printSubset(Arrays.asList(6));
        verifyNoMoreInteractions(print);
    }

    @Test
    public void testSubset55() throws Exception {
        PrintSubset print = mock(PrintSubset.class);
        SubsetSum sum = new SubsetSum(print);
        sum.subsetSum(55, Arrays.asList(15, 20, 30, 40, 55));
        verify(print).printSubset(Arrays.asList(15, 40));
        verify(print).printSubset(Arrays.asList(55));
        verifyNoMoreInteractions(print);
    }

    @Test
    public void testSum55SubsetEmpty() throws Exception {
        PrintSubset print = mock(PrintSubset.class);
        SubsetSum sum = new SubsetSum(print);
        sum.subsetSum(55, Arrays.asList(15, 30, 60, 80, 90));
        verifyNoMoreInteractions(print);
    }


}
