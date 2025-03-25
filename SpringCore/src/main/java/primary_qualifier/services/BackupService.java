package primary_qualifier.services;

import lombok.extern.log4j.Log4j2;
import primary_qualifier.IService;

@Log4j2
public class BackupService implements IService
{
    public BackupService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public String invoke() {
        return "Backup-Result";
    }
}