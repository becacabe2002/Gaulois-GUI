package application.utils;

import application.models.*;
import javafx.collections.ObservableList;
//import java.util.Iterator;
import javafx.collections.FXCollections;


public class Linker {
	/*
	 * Dia Diem:
	 * - Related NhanVat[]
	 * - Related SuKien[]
	*/
	public static ObservableList<NhanVat> NVLinkedDD(DiaDiem dd, ObservableList<NhanVat> inputNV){
		ObservableList<NhanVat> res = FXCollections.observableArrayList();
		for(String nv : dd.getNhanVat()) {
			for(int i = 0; i < inputNV.size();i++) {
				NhanVat tempNV = inputNV.get(i);
				String tempName = tempNV.getTitle();
				if(tempName.toLowerCase().contains(nv)) {
					res.add(tempNV);
				} else continue;
			}
		}
		return res;
	}
	
	public static ObservableList<SuKien> SKLinkedDD(DiaDiem dd, ObservableList<SuKien> inputSK){
		ObservableList<SuKien> res = FXCollections.observableArrayList();
		for(String sk : dd.getSuKien()) {
			for(int i = 0; i < inputSK.size();i++) {
				SuKien tempSK = inputSK.get(i);
				String tempName = tempSK.getTitle();
				if(tempName.toLowerCase().contains(sk)) {
					res.add(tempSK);
				} else continue;
			}
		}
		return res;
	}

	/*
	 * Le Hoi:
	 * - Related DiaDiem
	 * - Related NhanVat[]
	*/
	public static ObservableList<DiaDiem> DDLinkedLH(LeHoi lh, ObservableList<DiaDiem> inputDiaDiem){
		ObservableList<DiaDiem> res = FXCollections.observableArrayList();
		String nameDiaDiem = lh.getLocation();
			for(int i = 0; i < inputDiaDiem.size();i++) {
				DiaDiem tempDD = inputDiaDiem.get(i);
				String tempName = tempDD.getTitle();
				if(tempName.toLowerCase().contains(nameDiaDiem)) {
					res.add(tempDD);
				} else continue;
			}
		return res;
	}
	

	public static ObservableList<NhanVat> NVLinkedLH(LeHoi lh, ObservableList<NhanVat> inputNV){
		ObservableList<NhanVat> res = FXCollections.observableArrayList();
		for(String nv : lh.getHistorical_Characters()) {
			for(int i = 0; i < inputNV.size();i++) {
				NhanVat tempNV = inputNV.get(i);
				String tempName = tempNV.getTitle();
				if(tempName.toLowerCase().contains(nv)) {
					res.add(tempNV);
				} else continue;
			}
		}
		return res;
	}
	
	/*
	 * Nhan Vat:
	 * - Related SuKien[]
	 * - Related NhanVat[]
	 * - Related DiaDiem[]
	 */
	public static ObservableList<SuKien> SKLinkedNV(NhanVat nv, ObservableList<SuKien> inputSK){
		ObservableList<SuKien> res = FXCollections.observableArrayList();
		for(String sk : nv.getNhanVat()) {
			for(int i = 0; i < inputSK.size();i++) {
				SuKien tempSK = inputSK.get(i);
				String tempName = tempSK.getTitle();
				if(tempName.toLowerCase().contains(sk)) {
					res.add(tempSK);
				} else continue;
			}
		}
		return res;
	}
	
	public static ObservableList<NhanVat> NVLinkedNV(NhanVat nv, ObservableList<NhanVat> inputNV){
		ObservableList<NhanVat> res = FXCollections.observableArrayList();
		for(String nvStr : nv.getNhanVat()) {
			for(int i = 0; i < inputNV.size();i++) {
				NhanVat tempNV = inputNV.get(i);
				String tempName = tempNV.getTitle();
				if(tempName.toLowerCase().contains(nvStr)) {
					res.add(tempNV);
				} else continue;
			}
		}
		return res;
	}
	
	public static ObservableList<DiaDiem> DDLinkedNV(NhanVat nv, ObservableList<DiaDiem> inputDD){
		ObservableList<DiaDiem> res = FXCollections.observableArrayList();
		for(String dd : nv.getDiaDiem()) {
			for(int i = 0; i < inputDD.size();i++) {
				DiaDiem tempDD = inputDD.get(i);
				String tempName = tempDD.getTitle();
				if(tempName.toLowerCase().contains(dd)) {
					res.add(tempDD);
				} else continue;
			}
		}
		return res;
	}
	
	/*
	 * Su Kien:
	 * - Related TrieuDai
	 * - Related NhanVat[]
	 * - Related DiaDiem
	*/
	public static ObservableList<TrieuDai> TDLinkedSK(SuKien sk, ObservableList<TrieuDai> inputTD){
		ObservableList<TrieuDai> res = FXCollections.observableArrayList();
		String tdStr = sk.getTrieuDai();
		for(int i = 0; i < inputTD.size();i++) {
			TrieuDai tempTD = inputTD.get(i);
			String tempName = tempTD.getTitle();
			if(tempName.toLowerCase().contains(tdStr)) {
				res.add(tempTD);
			} else continue;
		}
		return res;
	}
	
	public static ObservableList<NhanVat> NVLinkedSK(SuKien sk, ObservableList<NhanVat> inputNV){
		ObservableList<NhanVat> res = FXCollections.observableArrayList();
		for(String nv : sk.getNhanVat()) {
			for(int i = 0; i < inputNV.size();i++) {
				NhanVat tempNV = inputNV.get(i);
				String tempName = tempNV.getTitle();
				if(tempName.toLowerCase().contains(nv)) {
					res.add(tempNV);
				} else continue;
			}
		}
		return res;
	}
	
	public static ObservableList<DiaDiem> DDLinkedSK(SuKien sk, ObservableList<DiaDiem> inputDD){
		ObservableList<DiaDiem> res = FXCollections.observableArrayList();
		for(String dd : sk.getDiaDiem()) {
			for(int i = 0; i < inputDD.size();i++) {
				DiaDiem tempDD = inputDD.get(i);
				String tempName = tempDD.getTitle();
				if(tempName.toLowerCase().contains(dd)) {
					res.add(tempDD);
				} else continue;
			}
		}
		return res;
	}
	
	/*
	 * Trieu Dai:
	 * - Related Su Kien[]
	 * - Related Nhan Vat[]
	 * - Related Dia Diem[]
	 */
	public static ObservableList<SuKien> SKLinkedTD(TrieuDai td, ObservableList<SuKien> inputSK){
		ObservableList<SuKien> res = FXCollections.observableArrayList();
		for(String sk : td.getSuKien()) {
			for(int i = 0; i < inputSK.size();i++) {
				SuKien tempSK = inputSK.get(i);
				String tempName = tempSK.getTitle();
				if(tempName.toLowerCase().contains(sk)) {
					res.add(tempSK);
				} else continue;
			}
		}
		return res;
	}
	
	public static ObservableList<NhanVat> NVLinkedTD(TrieuDai td, ObservableList<NhanVat> inputNV){
		ObservableList<NhanVat> res = FXCollections.observableArrayList();
		for(String nv : td.getNhanVat()) {
			for(int i = 0; i < inputNV.size();i++) {
				NhanVat tempNV = inputNV.get(i);
				String tempName = tempNV.getTitle();
				if(tempName.toLowerCase().contains(nv)) {
					res.add(tempNV);
				} else continue;
			}
		}
		return res;
	}
	
	public static ObservableList<DiaDiem> DDLinkedTD(TrieuDai td, ObservableList<DiaDiem> inputDD){
		ObservableList<DiaDiem> res = FXCollections.observableArrayList();
		for(String dd : td.getDiaDiem()) {
			for(int i = 0; i < inputDD.size();i++) {
				DiaDiem tempDD = inputDD.get(i);
				String tempName = tempDD.getTitle();
				if(tempName.toLowerCase().contains(dd)) {
					res.add(tempDD);
				} else continue;
			}
		}
		return res;
	}
}
