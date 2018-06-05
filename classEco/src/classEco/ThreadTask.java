package classEco;

import java.util.Iterator;
import java.util.List;

public class ThreadTask implements Runnable {
	ClassEcoDAO dao = new ClassEcoDAO();
	List<ClassEcoVO> list = dao.getList();

	@Override
	public void run() {
		while (true) {
			dataControl();
		}
	}

	public void dataControl() {
		Iterator<ClassEcoVO> iter = list.iterator();
		
		if(iter.hasNext()) {
			long time = System.currentTimeMillis();
			
			ClassEcoVO vo = iter.next();
			System.out.print(" | [Temperature] " + vo.getTemperature());
			System.out.print(" | [Humidity] " + vo.getHumidity());
			System.out.print(" | InnerDust] " + vo.getInnerDust());
			System.out.print(" | OuterDust] " + vo.getOuterDust());
			System.out.print(" | RegTime] " + vo.getRegtime());
			System.out.println();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
