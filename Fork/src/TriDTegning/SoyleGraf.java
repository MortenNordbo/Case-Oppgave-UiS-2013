package TriDTegning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;


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
	
	double oldHoyde ;
	double oldHoyde1;
	double oldHoyde2;
	double oldHoyde3;
	
	public SoyleGraf(ArrayList<ArrayList<PricePoint>> data)
	{
		DataFieldValue = data;
		
		oldHoyde = ((double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())/100-0.3; 
		oldHoyde1 = ((double) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice())/100-0.3;
		oldHoyde2 = ((double) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice())/100-0.3;
		oldHoyde3 = ((double) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice())/100-0.3;
		
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
	public void Animation(double[] newValues)
	{
		Transform3D newV = new Transform3D();
		tg.getTransform(newV);

		Vector3d scales = new Vector3d();
		newV.getScale(scales);


		System.out.println(scales.y*50);
		System.out.println(newValues[0]);
		double midler = 0.005;

		if(scales.y < newValues[0]/50)
		{
			while(scales.y < newValues[0]/50)
			{
				scales.y = scales.y += 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde += midler;
				newV.setTranslation(new Vector3d(-0.5,oldHoyde,0));
				tg.setTransform(newV);

			}
		}
		else
		{
			while(scales.y > newValues[0]/50)
			{
				scales.y = scales.y -= 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde -= midler;
				newV.setTranslation(new Vector3d(-0.5,oldHoyde,0));
				tg.setTransform(newV);

			}
		}

		tg1.getTransform(newV);

		newV.getScale(scales);



		if(scales.y < newValues[1]/50)
		{
			while(scales.y < newValues[1]/50)
			{
				scales.y = scales.y += 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde1 += midler;
				newV.setTranslation(new Vector3d(-0.25,oldHoyde1,0));
				tg1.setTransform(newV);

			}
		}
		else
		{
			while(scales.y > newValues[1]/50)
			{
				scales.y = scales.y -= 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde1 -= midler;
				newV.setTranslation(new Vector3d(-0.25,oldHoyde1,0));
				tg1.setTransform(newV);

			}
		}
		tg2.getTransform(newV);

		newV.getScale(scales);



		
		if(scales.y < newValues[2]/50){
			while(scales.y < newValues[2]/50)
			{
				scales.y = scales.y += 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde2 += midler;
				newV.setTranslation(new Vector3d(0,oldHoyde2,0));
				tg2.setTransform(newV);

			}
		}
		else
		{
			while(scales.y > newValues[2]/50)
			{
				scales.y = scales.y -= 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde2 -= midler;
				newV.setTranslation(new Vector3d(0,oldHoyde2,0));
				tg2.setTransform(newV);

			}
		}
		tg3.getTransform(newV);

		newV.getScale(scales);



		if(scales.y < newValues[3]/50)
		{


			while(scales.y < newValues[3]/50)
			{
				scales.y = scales.y += 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde3 += midler;
				newV.setTranslation(new Vector3d(0.25,oldHoyde3,0));
				tg3.setTransform(newV);

			}
		}
		else
		{
			while(scales.y > newValues[3]/50)
			{
				scales.y = scales.y -= 0.01;
				newV.setScale(new Vector3d(0.02,scales.y,0.02));

				try {Thread.sleep(100);}	//to make sure the last progressbar in loadingPanel is shown.
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
				oldHoyde3 -= midler;
				newV.setTranslation(new Vector3d(0.25,oldHoyde3,0));
				tg3.setTransform(newV);

			}
		}

	}
	public BranchGroup createStill()
	{
		BranchGroup root = new BranchGroup();
		Transform3D tr = new Transform3D();
		TransformGroup tgAxes;
		TransformGroup TGHolder = new TransformGroup();
		TGHolder.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		double[] values = new double[4];

		values[0] = (double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice();
		System.out.println((double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice());
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

		/*
		cyl = new Cylinder(1f, (float) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice(), ap);
		cyl1 = new Cylinder(1f, (float) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice(), ap);	
		cyl2 = new Cylinder(1f, (float) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice(), ap);
		cyl3 = new Cylinder(1f, (float) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice(), ap);
		 */

		cyl = new Cylinder(1f, 1f, ap);
		cyl1 = new Cylinder(1f, 1f, ap);
		cyl2 = new Cylinder(1f, 1f, ap);
		cyl3 = new Cylinder(1f, 1f, ap);

		cyl.setName("0");
		cyl1.setName("1");
		cyl2.setName("2");
		cyl3.setName("3");

		BoundingSphere bounds = new BoundingSphere();

		PickTool.setCapabilities(cyl.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);

		PickTool.setCapabilities(cyl1.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);

		PickTool.setCapabilities(cyl2.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);

		PickTool.setCapabilities(cyl3.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);


		Background background = new Background(1.0f, 1.0f, 1.0f);
		background.setApplicationBounds(bounds);

		PointLight ptlight = new PointLight(new Color3f(Color.green), 
				new Point3f(3f,3f,3f), new Point3f(1f,0f,0f));
		ptlight.setInfluencingBounds(bounds);

		PointLight ptlight2 = new PointLight(new Color3f(Color.red),
				new Point3f(-2f,2f,2f), new Point3f(1f,0f,0f));
		ptlight2.setInfluencingBounds(bounds);


		root.addChild(TGHolder);
		root.addChild(background);
		root.addChild(ptlight2);
		root.addChild(ptlight);
		TGHolder.addChild(tg);
		TGHolder.addChild(tg1);
		TGHolder.addChild(tg2);
		TGHolder.addChild(tg3);
		TGHolder.addChild(tgAxes);
		tg.addChild(cyl);
		tg1.addChild(cyl1);
		tg2.addChild(cyl2);
		tg3.addChild(cyl3);
		tgAxes.addChild(shape);
		return root;

	}
}
