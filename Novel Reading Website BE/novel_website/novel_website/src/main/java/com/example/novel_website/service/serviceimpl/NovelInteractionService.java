package com.example.novel_website.service.serviceimpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.NovelInteractionDTO;
import com.example.novel_website.enums.Interaction;
import com.example.novel_website.model.NovelInteraction;
import com.example.novel_website.repository.NovelInteractionRepository;
import com.example.novel_website.service.BaseService;
import com.example.novel_website.util.DateUtil;

@Service
public class NovelInteractionService extends BaseService<NovelInteraction, ObjectId, NovelInteractionDTO>{
    public void processNewRecord(String novelName, Interaction type, String value) { 
        LocalDate dateMark = LocalDate.now();

        NovelInteraction result = ((NovelInteractionRepository) repository).findRecord(novelName, dateMark, type);
        if (result != null) {
            updateRecord(novelName, dateMark, type, value);
        } else {
            addRecord(novelName, dateMark, type, value);
        }
    }

    private void addRecord(String novelName, LocalDate dateMark, Interaction type, String value) {
        NovelInteraction record = new NovelInteraction(novelName, dateMark, type, value);
        repository.save(record);
    }

    private void updateRecord(String novelName, LocalDate dateMark, Interaction type, String value) {
        NovelInteraction record = findRecord(novelName, dateMark, type);
        NovelInteraction updatedRecord = setValue(record, value);
        repository.save(updatedRecord);
    }

    private NovelInteraction findRecord(String novelName, LocalDate dateMark, Interaction type) {
        return ((NovelInteractionRepository) repository).findRecord(novelName, dateMark, type);
    }

    private NovelInteraction setValue(NovelInteraction record, String value) {
        String newValue = record.getValue() + "," + value;
        record.setValue(newValue);
        return record;
    }

    public List<String> getNovelsName(Interaction interactionType, String datetime) {
        // Calculate the date range based on the provided datetime parameter
        LocalDate startDate = DateUtil.calculateDateRange(datetime);
        LocalDate endDate = LocalDate.now(); // Assuming endDate is current date
      
        List<NovelInteraction> novelInteractions = ((NovelInteractionRepository) repository)
            .findNovelNameByInteractionTypeAndDateMark(interactionType, startDate, endDate);
      
        // Encapsulate sorting logic in a separate method
        List<NovelInteraction> sortedInteractions = sortByValue(novelInteractions);
      
        return extractNames(sortedInteractions);
    }
      
    private List<NovelInteraction> sortByValue(List<NovelInteraction> interactions) {
        // Define a Comparator based on the calculateValue logic
        Comparator<NovelInteraction> valueComparator = (interaction1, interaction2) -> 
            Double.compare(calculateValue(interaction2), calculateValue(interaction1));
      
        // Sort the list using the comparator
        Collections.sort(interactions, valueComparator);
        return interactions;
    }

    private List<String> extractNames(List<NovelInteraction> novelInteractions) {
        return novelInteractions.stream()
                .map(NovelInteraction::getNovelName)  // Extract name using method reference
                .collect(Collectors.toList());    // Collect results into a List<String>
    }

    private double calculateValue(NovelInteraction novelInteraction) {
        double total = 0;
        String valueString = novelInteraction.getValue().toString(); // Assuming there's a getValue() method
        String[] values = valueString.split(",");  // Split the string by commas

        for (String val : values) {
            total += Double.parseDouble(val); 
        }

        if (novelInteraction.getInteractionType().equals(Interaction.RATING)) {
            total = total / values.length; 
        } 

        return total;
    }

}
