package com.opportunity.ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class loads the card images for the Opportunity UI. See the instructions in OpportunityUI and on how to make use of the
 * image loader methods defined in this class.
 * 
 * @author Ryan Dimaunahan and Lance Alcabasa
 * @see OpportunityUI
 * @see ClickAction
 */
public class CardImageLoader {
	
	public static final int NO_IMAGE = -1;
	public static final int GET_TAX_RETURNS = 0;
	public static final int BIR_HUNTING_BEGINS = 1;
	public static final int RESTORE_BALANCE = 2;
	public static final int VACANT_PROPERTY_LOT = 3;
	public static final int STOCK_INVESTMENT = 4;
	public static final int TIME_INVESTMENT = 5;
	public static final int KAREN_DAIRY_A_LVL0 = 6;
	public static final int KAREN_DAIRY_A_LVL1 = 7;
	public static final int KAREN_DAIRY_A_LVL2 = 8;
	public static final int KAREN_DAIRY_A_LVL3 = 9;
	public static final int MIKKA_N_KO_LVL0 = 10;
	public static final int MIKKA_N_KO_LVL1 = 11;
	public static final int MIKKA_N_KO_LVL2 = 12;
	public static final int MIKKA_N_KO_LVL3 = 13;
	public static final int SA_RISSA_RESTORE_LVL0 = 14;
	public static final int SA_RISSA_RESTORE_LVL1 = 15;
	public static final int SA_RISSA_RESTORE_LVL2 = 16;
	public static final int SA_RISSA_RESTORE_LVL3 = 17;
	public static final int OSPY_THALL_LVL0 = 18;
	public static final int OSPY_THALL_LVL1 = 19;
	public static final int OSPY_THALL_LVL2 = 20;
	public static final int OSPY_THALL_LVL3 = 21;
	
	public static final int SMALL = 0;
	public static final int MEDIUM = 1;
	public static final int LARGE = 2;
	
	public static ArrayList<String> FILE_NAMES = new ArrayList<String>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -2954956358939369063L;

	{
		add("GetTaxReturns.jpg");
		add("BIRHuntingBegins.jpg");
		add("RestoreBalance.jpg");
		add("VacantPropertyLot.jpg");
		add("StockInvestment.jpg");
		add("TimeInvestment.jpg");
		
		add("KarenDairyALvl0.jpg");
		add("KarenDairyALvl1.jpg");
		add("KarenDairyALvl2.jpg");
		add("KarenDairyALvl3.jpg");
		
		add("MikkaNKoLvl0.jpg");
		add("MikkaNKoLvl1.jpg");
		add("MikkaNKoLvl2.jpg");
		add("MikkaNKoLvl3.jpg");
		
		add("SaRissaRestoreLvl0.jpg");
		add("SaRissaRestoreLvl1.jpg");
		add("SaRissaRestoreLvl2.jpg");
		add("SaRissaRestoreLvl3.jpg");
		
		add("OspyThallLvl0.jpg");
		add("OspyThallLvl1.jpg");
		add("OspyThallLvl2.jpg");
		add("OspyThallLvl3.jpg");
	}};
	
	private ArrayList<ImageIcon> largeImages;
	private ArrayList<ImageIcon> mediumImages;
	private ArrayList<ImageIcon> smallImages;
	
	
	/**
	 * Constructor that starts the image loading. This is called within OpportunityUI and should not be called instantiated elsewhere.
	 * 
	 * @see OpportunityUI
	 */
	public CardImageLoader() {
		loadImages();
	}
	
	private void loadImages() {
		
		this.largeImages = new ArrayList<ImageIcon>();
		this.mediumImages = new ArrayList<ImageIcon>();
		this.smallImages = new ArrayList<ImageIcon>();
		
		for (String fileName:CardImageLoader.FILE_NAMES) {
			String shortName = fileName;
			fileName = "src/com/opportunity/ui/resources/" + fileName;
			this.largeImages.add(loadLargeImage(fileName, shortName));
			this.mediumImages.add(loadMedumImage(fileName, shortName));
			this.smallImages.add(loadSmallImage(fileName, shortName));
		}
	}
	
	private ImageIcon loadLargeImage(String fileName, String shortName) {
		return new ImageIcon(fileName, shortName);
	}
	
	private ImageIcon loadMedumImage(String fileName, String shortName) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(Card.MEDIUM_CARD_WIDTH - 2, Card.MEDIUM_CARD_HEIGHT - 2,Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(dimg, shortName);
		return image;
	}
	
	private ImageIcon loadSmallImage(String fileName, String shortName) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(Card.SMALL_CARD_WIDTH - 2, Card.SMALL_CARD_HEIGHT - 2,Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(dimg, shortName);
		return image;
	}
	
	/**
	 * <p>Gets the large image for the specified card. Used for the blowup card label. Use the constants specified in this class as parameter to this method.</p>
	 * <p>For example:</p>
	 * 
	 * <code>this.getCardImageLoader().getLargeImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0)</code>
	 * 
	 * @param card Card image that will be obtained. Please use the constants defined in this class.
	 * @return the ImageIcon of the Card
	 */
	public ImageIcon getLargeImageIconFor(int card) {
		return this.largeImages.get(card);
	}
	
	/**
	 * <p>Gets the medium sized image for the specified card. Used for the investments and prime investment card labels. Use the constants specified in this class as parameter to this method.</p>
	 * <p>For example:</p>
	 * 
	 * <code>this.getCardImageLoader().getMediumImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0)</code>
	 * 
	 * @param card Card image that will be obtained. Please use the constants defined in this class.
	 * @return the ImageIcon of the Card
	 */
	public ImageIcon getMediumImageIconFor(int card) {
		return this.mediumImages.get(card);
	}
	
	/**
	 * <p>Gets the small sized image for the specified card. Use the constants specified in this class as parameter to this method.</p>
	 * <p>For example:</p>
	 * 
	 * <code>this.getCardImageLoader().getSmallImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0)</code>
	 * 
	 * @param card Card image that will be obtained. Please use the constants defined in this class.
	 * @return the ImageIcon of the Card
	 */
	public ImageIcon getSmallImageIconFor(int card) {
		return this.smallImages.get(card);
	}

}
