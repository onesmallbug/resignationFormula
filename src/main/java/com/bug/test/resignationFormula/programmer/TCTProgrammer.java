package com.bug.test.resignationFormula.programmer;

//TCT�X�A
public class TCTProgrammer extends Thread {

	// �H����¾���v�A���]TCT�X�A�@�i�h�N�Q��¾
	private Double resignationProbability = Math.random();

	// ���]TCT�X�A����
	private Double servility = Math.random();

	// ���]TCT�X�A��ҭn���n��¾���W�v�A�C����
	private Double frequency = (1 / Math.random()) * 1000;

	// TCT�`�u�@�q(�C�P�һ��`�u��)
	public static Integer TCTTotalWorkingHours = 1000;

	// TCT�`�X�A
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
		// ���]TCT�X�A���_�Q�n���n��¾
		while (true) {
			//�ӤH�C�g�u��
			Double workingHours = TCTTotalWorkingHours.doubleValue() / TCTTotalProgrammer.intValue();
			//�ӤH�C�g�u�ɲ��ͪ���¾�v
			Double environmentResignationProbability = Double.valueOf(servility.doubleValue() * workingHours);
			//�`��¾�v
			Double nowResignationProbability = Double.valueOf(environmentResignationProbability.doubleValue() + resignationProbability.doubleValue());
			if (nowResignationProbability >= 1) {
				// ���v�j�󵥩�1������¾�A�į��u��
				System.out.print("�O�ɭԸ���¾�F");
				break;
			} else if (Math.random() > resignationProbability) {
				// ���v�p��100%�����i����¾
				// �i�J�H����¾�P�_���p
				System.out.print("��M�Q��¾");
				break;
			}
			try {
				System.out.println("�����n��¾�n�F");
				System.out.println("�� : " + frequency.longValue());
				Thread.sleep(frequency.longValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �᳣̫�|��¾
		System.out.println("�A�{�����M�n��¾��");
	}
	
	private Integer afterCreate(TCTProgrammer self) {
		return ++TCTTotalProgrammer;
	}

}
