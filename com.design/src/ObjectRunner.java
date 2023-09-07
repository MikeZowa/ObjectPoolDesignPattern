import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ObjectRunner {
	
          private ObjectPool<ExportingProcess> pool;
	      private AtomicLong processNo=new AtomicLong(0);

	       public void setUp() {
               pool = new ObjectPool<ExportingProcess>(3, 6, 4) {
                   protected ExportingProcess createObject() {
                return new ExportingProcess( processNo.incrementAndGet());}
               };
    }

	public void tearDown() {
        pool.shutdown();
    }

    public void testObjectPool() {
    
    	ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.execute(new ExportingTask(pool, 1));
        executor.execute(new ExportingTask(pool, 2));
        executor.execute(new ExportingTask(pool, 3));
        executor.shutdown();
    }
}
