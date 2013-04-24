package TriDTegning;

import hooks.DatoConverter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Font3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Text3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;


import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.picking.PickCanvas;
import com.sun.j3d.utils.picking.PickResult;
import com.sun.j3d.utils.picking.PickTool;
import com.sun.j3d.utils.universe.SimpleUniverse;

import model.Entities.PricePoint;

public class SoyleGraf extends JPanel
{

	PickCanvas pc;
	ArrayList<ArrayList<PricePoint>> DataFieldValue;
	Canvas3D cv;

	Cylinder cyl;
	Cylinder cyl1;
	Cylinder cyl2;
	Cylinder cyl3;

	TransformGroup tg;
	TransformGroup tg1;
	TransformGroup tg2;
	TransformGroup tg3;

	TransformGroup text;
	TransformGroup text1;
	TransformGroup text2;
	TransformGroup text3;

	Text3D theText;
	Text3D theText1;
	Text3D theText2;
	Text3D theText3;
	
	Text3D dato;

	double oldHoyde ;
	double oldHoyde1;
	double oldHoyde2;
	double oldHoyde3;

	double TextHoyde;

	public SoyleGraf(ArrayList<ArrayList<PricePoint>> data)
	{
		DataFieldValue = data;

		oldHoyde = ((double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())/100-0.3; 
		oldHoyde1 = ((double) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice())/100-0.3;
		oldHoyde2 = ((double) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice())/100-0.3;
		oldHoyde3 = ((double) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice())/100-0.3;

		TextHoyde = ((double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())/100-3; 

		GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
		cv = new Canvas3D(gc);
		setLayout(new BorderLayout());
		add(cv, BorderLayout.CENTER);

		BranchGroup bg = createStill();
		bg.compile();
		pc = new PickCanvas(cv, bg);
		pc.setMode(PickTool.GEOMETRY);
		SimpleUniverse su = new SimpleUniverse(cv);
		su.getViewingPlatform().setNominalViewingTransform();
		su.addBranchGraph(bg);



	}
	public void Animation(double[] newValues, PricePoint datoFinder)
	{
//		Thread Thread1 = new Thread();
		Transform3D newV = new Transform3D();
		tg.getTransform(newV);

		Vector3d scales = new Vector3d();
		newV.getScale(scales);


		Transform3D newTextScale = new Transform3D();
		text.getTransform(newTextScale);

		double midler = 0.001;

		double value;
		
		int datoen = datoFinder.getObservationDate();
		String StringDato = String.valueOf(datoen);
		StringDato = DatoConverter.Convertorz(StringDato);
		
		dato.setString(StringDato);
		
		if(scales.y < newValues[0]/50)
		{
			while(scales.y < newValues[0]/50)
			{
				scales.y = scales.y += 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde += midler;
				newV.setTranslation(new Vector3d(-0.5,oldHoyde,0));
				tg.setTransform(newV);

				TextHoyde = oldHoyde*2;

				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(-0.56d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText.setString(String.valueOf(Dformat.format(value)));

				text.setTransform(newTextScale);

			}
		}
		else
		{
			while(scales.y > newValues[0]/50)
			{
				scales.y = scales.y -= 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde -= midler;
				newV.setTranslation(new Vector3d(-0.5,oldHoyde,0));
				tg.setTransform(newV);

				TextHoyde = oldHoyde*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(-0.56d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText.setString(String.valueOf(Dformat.format(value)));

				text.setTransform(newTextScale);

			}
		}

		tg1.getTransform(newV);

		newV.getScale(scales);

		text1.getTransform(newTextScale);


		if(scales.y < newValues[1]/50)
		{
			while(scales.y < newValues[1]/50)
			{
				scales.y = scales.y += 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde1 += midler;
				newV.setTranslation(new Vector3d(-0.25,oldHoyde1,0));
				tg1.setTransform(newV);

				TextHoyde = oldHoyde1*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(-0.31d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText1.setString(String.valueOf(Dformat.format(value)));

				text1.setTransform(newTextScale);
			}
		}
		else
		{
			while(scales.y > newValues[1]/50)
			{
				scales.y = scales.y -= 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde1 -= midler;
				newV.setTranslation(new Vector3d(-0.25,oldHoyde1,0));
				tg1.setTransform(newV);
				TextHoyde = oldHoyde1*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(-0.31d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText1.setString(String.valueOf(Dformat.format(value)));

				text1.setTransform(newTextScale);

			}
		}
		tg2.getTransform(newV);

		newV.getScale(scales);

		text2.getTransform(newTextScale);



		if(scales.y < newValues[2]/50){
			while(scales.y < newValues[2]/50)
			{
				scales.y = scales.y += 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde2 += midler;
				newV.setTranslation(new Vector3d(0,oldHoyde2,0));
				tg2.setTransform(newV);
				TextHoyde = oldHoyde2*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(-0.07d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText2.setString(String.valueOf(Dformat.format(value)));

				text2.setTransform(newTextScale);

			}
		}
		else
		{
			while(scales.y > newValues[2]/50)
			{
				scales.y = scales.y -= 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde2 -= midler;
				newV.setTranslation(new Vector3d(0,oldHoyde2,0));
				tg2.setTransform(newV);
				TextHoyde = oldHoyde2*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(-0.07d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText2.setString(String.valueOf(Dformat.format(value)));

				text2.setTransform(newTextScale);


			}
		}
		tg3.getTransform(newV);


		newV.getScale(scales);
		text3.getTransform(newTextScale);

		if(scales.y < newValues[3]/50)
		{


			while(scales.y < newValues[3]/50)
			{
				scales.y = scales.y += 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde3 += midler;
				newV.setTranslation(new Vector3d(0.25,oldHoyde3,0));
				tg3.setTransform(newV);
				TextHoyde = oldHoyde3*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(0.19d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText3.setString(String.valueOf(Dformat.format(value)));

				text3.setTransform(newTextScale);


			}
		}
		else
		{
			while(scales.y > newValues[3]/50)
			{
				scales.y = scales.y -= 0.002;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(10);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde3 -= midler;
				newV.setTranslation(new Vector3d(0.25,oldHoyde3,0));
				tg3.setTransform(newV);
				TextHoyde = oldHoyde3*2;
				newTextScale.setScale(0.05d);
				newTextScale.setTranslation(new Vector3d(0.19d,TextHoyde +0.4 ,0));
				DecimalFormat Dformat = new DecimalFormat();
				Dformat.setMinimumFractionDigits(2);


				value = scales.y*50;

				theText3.setString(String.valueOf(Dformat.format(value)));

				text3.setTransform(newTextScale);


			}
		}

	}
	public BranchGroup createStill()
	{
		BranchGroup root = new BranchGroup();
		Transform3D tr = new Transform3D();
		TransformGroup tgAxes;
		TransformGroup TGHolder = new TransformGroup();
		TransformGroup TextHolder = new TransformGroup();
		TransformGroup rotator = new TransformGroup();
		TransformGroup MarkedHolder = new TransformGroup();
		TransformGroup marked;
		TransformGroup marked1;
		TransformGroup marked2;
		TransformGroup marked3;
		TransformGroup datoHolder;
		rotator.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);




		double[] values = new double[4];
		values[0] = (double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice();
		values[1] = (double) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice();
		values[2] = (double) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice();
		values[3] = (double) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice();
		Group shape = new Axes();

		Appearance ap = new Appearance();
		ap.setMaterial(new Material());

		tr.setScale(new Vector3d(0.02,values[0]/50,0.02));
		tr.setTranslation(new Vector3d(-0.5,(((double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())/100)-0.3,0));
		tg = new TransformGroup(tr);
		tr.setIdentity();
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tr.setScale(new Vector3d(0.02,values[1]/50,0.02));
		tr.setTranslation(new Vector3d(-0.25,(((double) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice())/100)-0.3,0));
		tg1 = new TransformGroup(tr);

		tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tr.setIdentity();

		tr.setScale(new Vector3d(0.02,values[2]/50,0.02));
		tr.setTranslation(new Vector3d(0,(((double) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice())/100)-0.3,0));
		tg2 = new TransformGroup(tr);

		tg2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tr.setIdentity();

		tr.setScale(new Vector3d(0.02,values[3]/50,0.02));
		tr.setTranslation(new Vector3d(0.25,(((double) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice())/100)-0.3,0));
		tg3 = new TransformGroup(tr);

		tg3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tr.setIdentity();

		tr.setScale(0.5f);
		tr.setTranslation(new Vector3d(-0.75,0,0));
		tgAxes = new TransformGroup(tr);

		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(-0.56d,(((double)DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())/100), 0));
		text = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(-0.31d,(((double)DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice())/100), 0));
		text1 = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(-0.07d,(((double)DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice())/100), 0));
		text2 = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(0.19d,(((double)DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice())/100), 0));
		text3 = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(-0.54d,-0.4, 0));
		marked = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(-0.32d,-0.4, 0));
		marked1 = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(-0.04d,-0.4, 0));
		marked2 = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(0.15d,-0.4, 0));
		marked3 = new TransformGroup(tr);
		
		tr.setIdentity();
		tr.setScale(0.05f);
		tr.setTranslation(new Vector3d(0.25d,0.4, 0));
		datoHolder = new TransformGroup(tr);
		

		Font3D font = new Font3D(new Font("SansSerif", Font.PLAIN, 1),
				new FontExtrusion());
		
		
		theText = new Text3D(font, String.valueOf(((double)DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())));
		Shape3D TheShapedText = new Shape3D(theText, ap);


		text.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		theText.setCapability(Text3D.ALLOW_STRING_WRITE);


		theText1 = new Text3D(font, String.valueOf(((double)DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice())));
		Shape3D TheShapedText1 = new Shape3D(theText1, ap);


		text1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		theText1.setCapability(Text3D.ALLOW_STRING_WRITE);

		theText2 = new Text3D(font, String.valueOf(((double)DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice())));
		Shape3D TheShapedText2 = new Shape3D(theText2, ap);


		text2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		theText2.setCapability(Text3D.ALLOW_STRING_WRITE);

		theText3 = new Text3D(font, String.valueOf(((double)DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice())));
		Shape3D TheShapedText3 = new Shape3D(theText3, ap);


		text3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		theText3.setCapability(Text3D.ALLOW_STRING_WRITE);
		
		Text3D theTextMarked = new Text3D(font, "TTF");
		Shape3D TheShapedMarked = new Shape3D(theTextMarked, ap);
		
		Text3D theTextMarked1 = new Text3D(font, "Gaspool");
		Shape3D TheShapedMarked1 = new Shape3D(theTextMarked1, ap);
		
		Text3D theTextMarked2 = new Text3D(font, "NCG");
		Shape3D TheShapedMarked2 = new Shape3D(theTextMarked2, ap);
		
		Text3D theTextMarked3 = new Text3D(font, "Zeebrugge");
		Shape3D TheShapedMarked3 = new Shape3D(theTextMarked3, ap);
		
		dato = new Text3D(font,DatoConverter.Convertorz(String.valueOf((DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getObservationDate()))));
		
		Shape3D TheShapedDato = new Shape3D(dato, ap);
		

		datoHolder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		dato.setCapability(Text3D.ALLOW_STRING_WRITE);
		
		cyl = new Cylinder(1f, 1f, ap);
		cyl1 = new Cylinder(1f, 1f, ap);
		cyl2 = new Cylinder(1f, 1f, ap);
		cyl3 = new Cylinder(1f, 1f, ap);

		cyl.setName("0");
		cyl1.setName("1");
		cyl2.setName("2");
		cyl3.setName("3");

		BoundingSphere bounds = new BoundingSphere();



		Background background = new Background(1.0f, 1.0f, 1.0f);
		background.setApplicationBounds(bounds);

		PointLight ptlight = new PointLight(new Color3f(Color.green), 
				new Point3f(3f,3f,3f), new Point3f(1f,0f,0f));
		ptlight.setInfluencingBounds(bounds);

		PointLight ptlight2 = new PointLight(new Color3f(Color.red),
				new Point3f(-2f,2f,2f), new Point3f(1f,0f,0f));
		ptlight2.setInfluencingBounds(bounds);

		MouseRotate myMouseRotate = new MouseRotate();
		myMouseRotate.setTransformGroup(rotator);
		myMouseRotate.setSchedulingBounds(new BoundingSphere());
		root.addChild(myMouseRotate);


		root.addChild(background);
		root.addChild(ptlight2);
		root.addChild(ptlight);
		root.addChild(rotator);
		rotator.addChild(TGHolder);
		rotator.addChild(TextHolder);
		rotator.addChild(MarkedHolder);
		rotator.addChild(datoHolder);
		datoHolder.addChild(TheShapedDato);
		TGHolder.addChild(tg);
		TGHolder.addChild(tg1);
		TGHolder.addChild(tg2);
		TGHolder.addChild(tg3);
		TGHolder.addChild(tgAxes);
		TextHolder.addChild(text);
		TextHolder.addChild(text1);
		TextHolder.addChild(text2);
		TextHolder.addChild(text3);
		MarkedHolder.addChild(marked);
		MarkedHolder.addChild(marked1);
		MarkedHolder.addChild(marked2);
		MarkedHolder.addChild(marked3);
		marked.addChild(TheShapedMarked);
		marked1.addChild(TheShapedMarked1);
		marked2.addChild(TheShapedMarked2);
		marked3.addChild(TheShapedMarked3);
		tg.addChild(cyl);
		tg1.addChild(cyl1);
		tg2.addChild(cyl2);
		tg3.addChild(cyl3);
		text.addChild(TheShapedText);
		text1.addChild(TheShapedText1);
		text2.addChild(TheShapedText2);
		text3.addChild(TheShapedText3);
		tgAxes.addChild(shape);

		return root;

	}
}
