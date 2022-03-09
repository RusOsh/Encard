package com.rus.encard.ui.fragment.word;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.rus.encard.base.BaseFragment;
import com.rus.encard.databinding.FragmentWordBinding;
import com.rus.encard.ui.dialog.AddWordsFragment;
import com.rus.encard.ui.fragment.word.adapter.WordAdapter;


public class WordFragment extends BaseFragment<FragmentWordBinding> implements AddWordsFragment.Result {
    private WordViewModel wordViewModel;
    private final String Rus = "Rus";
    private WordAdapter wordAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        wordAdapter = new WordAdapter();
    }

    @Override
    protected FragmentWordBinding getBinding() {
        return FragmentWordBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBtn();
        initListener();
    }

    private void initListener() {
        binding.rvWord.setAdapter(wordAdapter);
        if (wordViewModel.getResponseMutableLiveData() != null) {
            wordViewModel.getResponseMutableLiveData().observe(getViewLifecycleOwner()
                    , pixaBayResponse ->
                            wordAdapter.setList(pixaBayResponse.getHits()));
        }

    }

    private void initBtn() {
        binding.btnNewWord.setOnClickListener(view ->
                new AddWordsFragment(this).show(requireActivity()
                        .getSupportFragmentManager(), Rus));
    }

    @Override
    public void putWord(String word) {
        wordViewModel.init(word);
    }
}