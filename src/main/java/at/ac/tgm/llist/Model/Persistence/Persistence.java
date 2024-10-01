package at.ac.tgm.llist.Model.Persistence;

import at.ac.tgm.llist.Model.Worttrainer;

public interface Persistence {
    void save(Worttrainer wt, String path);
    Worttrainer load(String path);
}
