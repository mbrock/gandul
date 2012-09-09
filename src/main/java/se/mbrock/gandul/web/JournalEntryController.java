package se.mbrock.gandul.web;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.mbrock.gandul.journal.Diagnosis;
import se.mbrock.gandul.journal.DiagnosisJournalEntry;
import se.mbrock.gandul.journal.JournalEntryRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/journal-entry")
public class JournalEntryController {

    @Resource
    private JournalEntryRepository journalEntryRepository;

    @RequestMapping("/{id}")
    public ModelAndView showJournalEntry(@PathVariable("id") String journalEntryId) {
        return new ModelAndView("journal-entry", "journalEntry", journalEntryRepository.findOne(journalEntryId));
    }

    @RequestMapping("/")
    public ModelAndView showAll() {
        return new ModelAndView("journal", "journalEntries", journalEntryRepository.findAll());
    }

    @RequestMapping("/new")
    public void makeNew(@RequestParam String text) {
        DiagnosisJournalEntry entry = new DiagnosisJournalEntry(text, true);
        entry.setDiagnoses(ImmutableList.of(
                new Diagnosis("Kolera", true),
                new Diagnosis("Cancer", false)));
        journalEntryRepository.save(entry);
    }
}
