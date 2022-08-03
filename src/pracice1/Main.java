package pracice1;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		try(WatchService service = FileSystems.getDefault().newWatchService()) {
			WatchKey watchKey;
			Path path = Paths.get("C:\\New folder");
			Map<WatchKey, Path> keyMap = new HashMap<>();
			keyMap.put(path.register(service,  
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY), path);
			/*do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				for(WatchEvent<?> event : watchKey.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path)event.context();
					System.out.println(eventDir + ": " + kind + ": " + eventPath);
				}
			} while(watchKey.reset());*/
		} catch(Exception e) {
			
		}
	}
}
