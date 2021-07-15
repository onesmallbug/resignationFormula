package com.bug.test.resignationFormula.programmer;

//TCT碼農
public class TCTProgrammer extends Thread {

	// 隨機離職機率，假設TCT碼農一進去就想離職
	private Double resignationProbability = Math.random();

	// 假設TCT碼農奴性
	private Double servility = Math.random();

	// 假設TCT碼農思考要不要離職的頻率，每秒次數
	private Double frequency = (1 / Math.random()) * 1000;

	// TCT總工作量(每周所需總工時)
	public static Integer TCTTotalWorkingHours = 1000;

	// TCT總碼農
	public static Integer TCTTotalProgrammer = 0;

	public TCTProgrammer(Double resignationProbability, Double servility) {
		super();
		if (resignationProbability != null) {
			this.resignationProbability = resignationProbability;
		}

		if (servility != null) {
			this.servility = servility;
		}
		afterCreate(this);
	}

	public TCTProgrammer() {
		afterCreate(this);
	}

	@Override
	public void run() {
		// 假設TCT碼農不斷想要不要離職
		while (true) {
			//個人每週工時
			Double workingHours = TCTTotalWorkingHours.doubleValue() / TCTTotalProgrammer.intValue();
			//個人每週工時產生的離職率
			Double environmentResignationProbability = Double.valueOf(servility.doubleValue() * workingHours);
			//總離職率
			Double nowResignationProbability = Double.valueOf(environmentResignationProbability.doubleValue() + resignationProbability.doubleValue());
			if (nowResignationProbability >= 1) {
				// 機率大於等於1直接離職，效能優化
				System.out.print("是時候該離職了");
				break;
			} else if (Math.random() > resignationProbability) {
				// 機率小於100%仍有可能離職
				// 進入隨機離職判斷狀況
				System.out.print("突然想離職");
				break;
			}
			try {
				System.out.println("先不要離職好了");
				System.out.println("睡 : " + frequency.longValue());
				Thread.sleep(frequency.longValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 最後都會離職
		System.out.println("，ㄌㄧㄣ杯要離職拉");
	}
	
	private Integer afterCreate(TCTProgrammer self) {
		return ++TCTTotalProgrammer;
	}

}
