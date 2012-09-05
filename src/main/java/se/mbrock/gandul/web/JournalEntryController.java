package se.mbrock.gandul.web;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.mbrock.gandul.journal.JournalEntry;
import se.mbrock.gandul.journal.JournalEntryRepository;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class JournalEntryController {

    @Resource
    private JournalEntryRepository journalEntryRepository;

    @ModelAttribute("journalEntries")
    public List<JournalEntry> getJournalEntries() {
        return Lists.newArrayList(journalEntryRepository.findAll());
    }

    @RequestMapping("/foo")
    public String getFoo() {
        return "foo";
    }

    @RequestMapping("/new-journal-entry")
    public void makeNew(@RequestParam String text) {
        journalEntryRepository.save(new JournalEntry(text, false));
    }
}
